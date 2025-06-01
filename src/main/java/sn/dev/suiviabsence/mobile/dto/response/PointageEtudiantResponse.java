package sn.dev.suiviabsence.mobile.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Informations de l'étudiant pour le pointage")
public class PointageEtudiantResponse {
    @Schema(description = "Matricule de l'étudiant", example = "ET001")
    private String matricule;
    @Schema(description = "Nom de l'étudiant", example = "Diop")
    private String nom;
    @Schema(description = "prenom de l'étudiant", example = "Fallou")
    private String prenom;
    @Schema(description = "le Cours en cours", example = "Mathématiques Appliquées")
    private String coursNom;
    @Schema(description = "Heure de début du cours", example = "08:00")
    private String heureDebut;
    @Schema(description = "Heure de fin du cours", example = "10:00")
    private String heureFin;
}
