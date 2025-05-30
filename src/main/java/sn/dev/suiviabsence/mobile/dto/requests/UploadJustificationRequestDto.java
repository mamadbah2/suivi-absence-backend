package com.suiviabsence.mobile.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadJustificationRequest {
    private MultipartFile fichier;
    private String commentaireEtudiant;
}