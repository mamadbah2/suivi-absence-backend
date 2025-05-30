<<<<<<< HEAD
package com.suiviabsence.mobile.dto.requests;
=======
package sn.dev.suiviabsence.mobile.dto.requests;
>>>>>>> 697837cc0faf9aae1d19ed9838b152c98bb0a92f

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