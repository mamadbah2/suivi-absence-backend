package sn.dev.suiviabsence.mobile.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.dev.suiviabsence.data.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Réponse de connexion avec token JWT et informations utilisateur")
public class UserLoginResponse {
    @Schema(description = "Token JWT pour l'authentification", example = "eyJhbGciOiJIUzI1NiIs...")
    private String token;
    @Schema(description = "Email de l'utilisateur", example = "vigile@groupism.sn")
    private String email;
    @Schema(description = "Nom de l'utilisateur", example = "Diop")
    private String nom;
    @Schema(description = "Prénom de l'utilisateur", example = "Amadou")
    private String prenom;
    @Schema(description = "Rôle de l'utilisateur", example = "VIGILE")
    private Role role;
    @Schema(description = "Matricule de l'étudiant (uniquement pour les étudiants)", example = "ET001")
    private String matricule; // Pour les étudiants, null pour les autres utilisateurs
    @Schema(description = "Image de l'étudiant (uniquement pour les étudiants)", example = "ET001")
    private String image;

    // Constructeur original maintenu pour compatibilité
    public UserLoginResponse(String token) {
        this.token = token;
    }
    
    // Constructeur pour les utilisateurs non-étudiants
    public UserLoginResponse(String token, String email, String nom, String prenom, Role role, String image) {
        this.token = token;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.image = image;
        this.matricule = null;
    }
}
