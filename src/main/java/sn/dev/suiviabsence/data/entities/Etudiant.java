package sn.dev.suiviabsence.data.entities;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Etudiant {
    String matricule;
    List<Absence> absences;
    Classe classe;
}
