package sn.dev.suiviabsence.web.dto.requests;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AbsenceRequestDto {

    private String matricule;
    private String nom;
    private String prenom;
    private String classe;
    private String module;
    private String date;
    private String heure;
    private String status;




}
