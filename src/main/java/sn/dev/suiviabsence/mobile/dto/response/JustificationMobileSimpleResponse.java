package com.suiviabsence.mobile.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class JustificationResponse {
    private Long id;
    private String statut;
    private String fichierUrl;
    private String commentaireEtudiant;
    private String commentaireAdmin;
    private LocalDateTime creeLe;
}