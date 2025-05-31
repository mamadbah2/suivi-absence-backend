package sn.dev.suiviabsence.mobile.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.dev.suiviabsence.mobile.dto.requests.UserLoginRequest;
import sn.dev.suiviabsence.mobile.dto.response.UserLoginResponse;

@RequestMapping("app/auth")
@Tag(name = "Authentification", description = "API d'authentification")
public interface AuthController {

    @Operation(summary = "Connexion utilisateur", description = "Permet à un utilisateur de se connecter avec ses identifiants pour obtenir un token JWT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Authentification réussie",
                content = @Content(schema = @Schema(implementation = UserLoginResponse.class))),
        @ApiResponse(responseCode = "401", description = "Identifiants incorrects"),
        @ApiResponse(responseCode = "500", description = "Erreur serveur")
    })
    @PostMapping("/login")
    ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request);
}
