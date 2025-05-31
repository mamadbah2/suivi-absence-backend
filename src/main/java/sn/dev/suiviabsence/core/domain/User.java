package sn.dev.suiviabsence.core.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import sn.dev.suiviabsence.core.domain.enums.Role;

@Document
@Data
public class User {
    String id;
    String nom;
    String prenom;
    String email;
    String password;
    Role role;
} 