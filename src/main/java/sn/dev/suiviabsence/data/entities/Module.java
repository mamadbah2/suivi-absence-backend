package sn.dev.suiviabsence.data.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
public class Module {
    String id;
    String nom;
    Classe classe;
    String nomProf;

}
