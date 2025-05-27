package sn.dev.suiviabsence.data.entities;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document
@Data
public class Absence {
     String id;
     String heure;
     String justification;
     String nomModule;
     String matriculeEtudiant;
}
