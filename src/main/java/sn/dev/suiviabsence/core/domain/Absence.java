package sn.dev.suiviabsence.core.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    String status;

    public String getJustificatif() {
        return justification;
    }
} 