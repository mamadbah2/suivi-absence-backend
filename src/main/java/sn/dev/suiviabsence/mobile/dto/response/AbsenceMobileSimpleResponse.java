package sn.dev.suiviabsence.mobile.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.data.entities.Classe;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AbsenceMobileSimpleResponse {
    String nom;
    String prenom;
    String classe;
    String module;
    String heureDebut;
    String heureFin;
}
