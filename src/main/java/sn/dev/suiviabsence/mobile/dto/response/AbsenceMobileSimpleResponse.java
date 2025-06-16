package sn.dev.suiviabsence.mobile.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.dev.suiviabsence.data.enums.Status;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Schema(description = "Réponse simplifiée pour les absences mobile")
public class AbsenceMobileSimpleResponse {
    @Schema(description = "Matricule de l'étudiant", example = "ETD001")
    String matricule;
    @Schema(description = "Nom  de l'étudiant", example = "Diop")
    String nom;
    @Schema(description = "prenom  de l'étudiant", example = "Amadou")
    String prenom;
    @Schema(description = "Nom de la classe", example = "GLRS2")
    String classe;
    @Schema(description = "le module", example = "Management du processus")
    String module;
    @Schema(description = "Heure de début du cours", example = "08:00")
    String heureDebut;
    @Schema(description = "Heure de fin du cours", example = "12:00")
    String heureFin;
    @Schema(description = "Statut de présence", example = "PRESENT")
    Status status;
}
