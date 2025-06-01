package sn.dev.suiviabsence.web.dto.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AbsenceRequestDto {
    private String id;
    private String matricule;
    private String nom;
    private String prenom;
    private String classe;
    private String module;
    private String date;
    private String heure;
    private String status;





}
