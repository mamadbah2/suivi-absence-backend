package sn.dev.suiviabsence.mobile.dto.requests;


import lombok.Data;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AbsenceRequestMobileDto {

    private String matricule;
    private String nom;
    private String prenom;
    private String classe;
    private String module;
    private LocalDate date;
    private String heure;
    private String status;
    private String justificationFileUrl;



}




