package sn.dev.suiviabsence.mobile.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.dev.suiviabsence.data.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponse {
    private String token;
    private String email;
    private String nom;
    private String prenom;
    private Role role;
    private String matricule; // Pour les étudiants, null pour les autres utilisateurs
    
    // Constructeur original maintenu pour compatibilité
    public UserLoginResponse(String token) {
        this.token = token;
    }
    
    // Constructeur pour les utilisateurs non-étudiants
    public UserLoginResponse(String token, String email, String nom, String prenom, Role role) {
        this.token = token;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.matricule = null;
    }
}
