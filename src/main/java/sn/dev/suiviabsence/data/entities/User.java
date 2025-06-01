package sn.dev.suiviabsence.data.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import sn.dev.suiviabsence.data.enums.Role;

    @Document
    @Data
    public class User {
        String id;
        String nom;
        String prenom;
        String email;
        String image;
        String password;
        Role role;
    }
