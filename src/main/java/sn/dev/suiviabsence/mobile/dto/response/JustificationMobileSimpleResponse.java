package sn.dev.suiviabsence.dto.responses;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class JustificationResponse {
    private Long id;
    private String nomEtudiant;
    private String matriculeEtudiant;
    private String nomCours;
    private LocalDateTime dateAbsence;
    private String statut; // EN_ATTENTE/VALIDEE/REJETEE
    private String urlJustificatif;
    private LocalDateTime dateValidation;
    private String nomValidateur;
    private String commentaireAdmin;
}
