package sn.dev.suiviabsence.mobile.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.dev.suiviabsence.data.enums.Status;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Réponse contenant les informations d'un étudiant et toutes ses absences")
public class EtudiantAbsencesResponse {
    @Schema(description = "Matricule de l'étudiant", example = "ETD001")
    private String matricule;

    @Schema(description = "Nom de l'étudiant", example = "Fall")
    private String nom;

    @Schema(description = "Prénom de l'étudiant", example = "Aminata")
    private String prenom;

    @Schema(description = "Nom de la classe", example = "GLRS_L3")
    private String classe;

    @Schema(description = "Liste des absences de l'étudiant")
    private List<AbsenceDetail> absences;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "Détails d'une absence")
    public static class AbsenceDetail {
        @Schema(description = "Identifiant unique de l'absence", example = "62f5e8ab1234567890abcdef")
        private String id;

        @Schema(description = "Date du cours", example = "2025-05-31")
        private String date;

        @Schema(description = "Heure de début du cours", example = "08:00")
        private String heureDebut;

        @Schema(description = "Heure de fin du cours", example = "12:00")
        private String heureFin;

        @Schema(description = "Nom du module", example = "Programmation Web")
        private String module;

        @Schema(description = "Nom du professeur", example = "Baila Wane")
        private String professeur;

        @Schema(description = "Statut de présence", example = "ABSENT")
        private Status status;

        @Schema(description = "Justification (si applicable)", example = "Certificat médical")
        private String justification;

        @Schema(description = "Heure de pointage (si applicable)", example = "07:55")
        private String heurePointage;
    }
}