package sn.dev.suiviabsence.core.domain;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

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