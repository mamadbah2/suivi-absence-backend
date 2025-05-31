package sn.dev.suiviabsence.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "etudiants")
public class Etudiant {
  @Id
  private String id;
  private String nom;
  private String prenom;
  private String classe;
}