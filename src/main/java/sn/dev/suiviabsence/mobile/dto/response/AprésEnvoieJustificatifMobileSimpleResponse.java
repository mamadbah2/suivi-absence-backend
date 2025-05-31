package sn.dev.suiviabsence.dto.responses;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class JustificatifResponse {
    private Long id;
    private String nomEtudiant;
    private String nomFichier;
    private String urlTelechargement;
    private LocalDateTime dateDepot;
    private String statut; // REÇU/EN_TRAITEMENT/TRAITÉ
    private String commentaireEtudiant;
}
