package sn.dev.suiviabsence.mobile.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UploadJustificationRequest {
    private String absenceId; // ID de l'absence à justifier
    private String motif; // Motif de la justification
    private String commentaireEtudiant; // Justification textuelle
    private List<String> imageUrls; // Liste des URLs des images justificatives
}