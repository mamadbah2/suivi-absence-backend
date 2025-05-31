package sn.dev.suiviabsence.dto.requests;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.*;

@Data
public class EnvoiJustificatifRequest {
    
    @NotNull(message = "Le fichier est obligatoire")
    private MultipartFile fichier;
    
    @Size(max = 500, message = "Le commentaire ne doit pas dépasser 500 caractères")
    private String commentaireEtudiant;
    
    @NotNull(message = "L'ID de l'étudiant est obligatoire")
    private Long etudiantId;
}
