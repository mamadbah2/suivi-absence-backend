package sn.dev.suiviabsence.mobile.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UploadJustificationRequest {
    private MultipartFile fichier;
    private String commentaireEtudiant;
}