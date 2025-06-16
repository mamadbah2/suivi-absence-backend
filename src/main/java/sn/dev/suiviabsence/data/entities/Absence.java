package sn.dev.suiviabsence.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import sn.dev.suiviabsence.data.enums.Status;
import java.util.List;

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
   List<String> justificatifsUrls; // Liste des URLs des images justificatives stockées dans le cloud

   public void setStatus(Status nouveauStatut) {
      this.status = nouveauStatut;
   }

   // Implémentation pour convertir une String en Status
   public void setStatus(String name) {
      try {
         this.status = Status.valueOf(name);
      } catch (IllegalArgumentException e) {
         throw new IllegalArgumentException("Status invalide: " + name);
      }
   }
}
