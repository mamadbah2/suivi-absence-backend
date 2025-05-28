package sn.dev.suiviabsence.data.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import sn.dev.suiviabsence.data.enums.Filiere;
import sn.dev.suiviabsence.data.enums.Niveau;

import java.util.List;

@Document
@Data
public class Classe {
    String id;
    String nom;
    Filiere filiere;
    Niveau niveau;
    List<Etudiant> etudiants;
}
