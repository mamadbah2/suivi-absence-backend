package sn.dev.suiviabsence.data.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Document
@Data
public class Cours {
    String id;
    String heureDebut;
    String heureFin;
    String date;
    Module module;
    List<Absence> absences;
    Classe classe;
}
