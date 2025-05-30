package sn.dev.suiviabsence.mobile.dto.response;

import lombok.Data;

@Data
public class PointageEtudiantResponse {
    private String matricule;
    private String nom;
    private String prenom;
    private String coursNom;
    private String heureDebut;
    private String heureFin;
}
