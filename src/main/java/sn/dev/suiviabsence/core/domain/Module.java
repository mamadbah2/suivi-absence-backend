package sn.dev.suiviabsence.core.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Module {
    String id;
    String nom;
    Classe classe;
    String nomProf;
} 