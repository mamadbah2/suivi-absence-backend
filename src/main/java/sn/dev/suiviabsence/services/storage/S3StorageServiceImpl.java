package sn.dev.suiviabsence.services.storage;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class S3StorageServiceImpl implements CloudStorageService {

    private final AmazonS3 amazonS3Client;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    @Override
    public String uploadFile(MultipartFile file, String prefix) throws IOException {
        String fileName = generateUniqueFileName(file.getOriginalFilename());
        String key = prefix + "/" + fileName;
        
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());
        
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(
                bucketName,
                key,
                file.getInputStream(),
                metadata
            ).withCannedAcl(CannedAccessControlList.PublicRead);
            
            amazonS3Client.putObject(putObjectRequest);
            return amazonS3Client.getUrl(bucketName, key).toString();
        } catch (Exception e) {
            log.error("Error uploading file to S3: {}", e.getMessage());
            throw new IOException("Failed to upload file to S3", e);
        }
    }

    @Override
    public List<String> uploadFiles(List<MultipartFile> files, String prefix) throws IOException {
        List<String> uploadedFileUrls = new ArrayList<>();
        
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String fileUrl = uploadFile(file, prefix);
                uploadedFileUrls.add(fileUrl);
            }
        }
        
        return uploadedFileUrls;
    }

    @Override
    public boolean deleteFile(String fileUrl) {
        try {
            // Extraire la clé du fichier à partir de l'URL
            String key = fileUrl.substring(fileUrl.indexOf(bucketName) + bucketName.length() + 1);
            
            if (amazonS3Client.doesObjectExist(bucketName, key)) {
                amazonS3Client.deleteObject(bucketName, key);
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error("Error deleting file from S3: {}", e.getMessage());
            return false;
        }
    }
    
    private String generateUniqueFileName(String originalFileName) {
        String extension = "";
        if (originalFileName.contains(".")) {
            extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        }
        return UUID.randomUUID().toString() + extension;
    }
}
