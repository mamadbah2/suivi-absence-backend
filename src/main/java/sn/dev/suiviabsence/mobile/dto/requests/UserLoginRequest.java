package sn.dev.suiviabsence.mobile.dto.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Requête de connexion utilisateur")
public class UserLoginRequest {
    @NotNull
    @Schema(
            description = "Adresse email de l'utilisateur",
            example = "vigile@esp.sn",
            required = true
    )
    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Format d'email invalide")
    private String email;

    @NotNull
    @Schema(
            description = "Mot de passe de l'utilisateur",
            example = "motdepasse123",
            required = true
    )
    @NotBlank(message = "Le mot de passe est obligatoire")
    private String password;
}
