package sn.dev.suiviabsence.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import sn.dev.suiviabsence.data.enums.Status;
import java.util.List;
import java.util.ArrayList;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Absence {
   String id;
   String heure;
   String date;
   String justification;
   // Liste des URLs des justificatifs stockés
   List<String> justificatifs = new ArrayList<>();
   Etudiant etudiant;
   Cours cours;
   Status status;

   public void setStatus(Status nouveauStatut) {
      this.status = nouveauStatut;
   }

   public void setStatus(String name) {
      try {
         this.status = Status.valueOf(name);
      } catch (IllegalArgumentException e) {
         throw new IllegalArgumentException("Status invalide: " + name);
      }
   }

   public void addJustificatif(String justificatif) {
      if (this.justificatifs == null) {
         this.justificatifs = new ArrayList<>();
      }
      this.justificatifs.add(justificatif);
   }


}