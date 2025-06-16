package sn.dev.suiviabsence.services.storage;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface CloudStorageService {
    /**
     * Télécharge un fichier dans le stockage cloud et retourne son URL
     * @param file Le fichier à télécharger
     * @param prefix Préfixe du chemin de stockage (dossier)
     * @return L'URL publique du fichier téléchargé
     */
    String uploadFile(MultipartFile file, String prefix) throws IOException;

    /**
     * Télécharge plusieurs fichiers dans le stockage cloud et retourne leurs URLs
     * @param files La liste des fichiers à télécharger
     * @param prefix Préfixe du chemin de stockage (dossier)
     * @return Les URLs publiques des fichiers téléchargés
     */
    List<String> uploadFiles(List<MultipartFile> files, String prefix) throws IOException;

    /**
     * Supprime un fichier du stockage cloud
     * @param fileUrl L'URL du fichier à supprimer
     * @return true si la suppression est réussie
     */
    boolean deleteFile(String fileUrl);
}
