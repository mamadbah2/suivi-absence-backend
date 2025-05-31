package sn.dev.suiviabsence.data.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import sn.dev.suiviabsence.data.enums.Status;

import java.time.LocalDateTime;
import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Absence {
     String id;
     String heure;
     String date;
     String justification;
     Etudiant etudiant;
     Cours cours;
     Status status;
     public void setStatus(Status nouveauStatut) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
     }
     public void setStatus(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
     }
}
