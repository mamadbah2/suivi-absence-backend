package sn.dev.suiviabsence.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "absences")
public class Absence {
  @Id
  private String id;

  @DocumentReference
  private Etudiant etudiant;

  @DocumentReference
  private Cours cours;

  private Date date;
  private String status;
  private String justification;
  private String justificatif;
}