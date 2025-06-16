package sn.dev.suiviabsence.mobile.controllers.impl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import sn.dev.suiviabsence.data.entities.Etudiant;
import sn.dev.suiviabsence.data.entities.User;
import sn.dev.suiviabsence.mobile.controllers.AuthController;
import sn.dev.suiviabsence.mobile.dto.requests.UserLoginRequest;
import sn.dev.suiviabsence.mobile.dto.response.UserLoginResponse;
import sn.dev.suiviabsence.security.JwtUtils;
import sn.dev.suiviabsence.services.UserService;

@RestController
@Tag(name = "Authentification", description = "Gestion de l'authentification des utilisateurs")
public class AuthControllerImpl implements AuthController {

    private final UserService userService;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    public AuthControllerImpl(UserService userService, JwtUtils jwtUtils, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Operation(
            summary = "Connexion utilisateur",
            description = "Authentifie un utilisateur (étudiant ou vigile) et retourne un token JWT avec les informations utilisateur"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Connexion réussie",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UserLoginResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Email incorrect ou mot de passe incorrect",
                    content = @Content(schema = @Schema(implementation = String.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Données de requête invalides"
            )
    })
    public ResponseEntity<UserLoginResponse> login(UserLoginRequest request) {
        System.out.println("\n*****************START login");
        User checkUser = userService.getByEmail(request.getEmail());

        if (checkUser == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect email");
        }

        System.out.println("--------------------------------------------------------------------------------------------: " + checkUser);
        System.out.println("Vérification du mot de passe pour: " + request.getEmail());

        if (passwordEncoder.matches(request.getPassword(), checkUser.getPassword())) {
            String token = jwtUtils.generateToken(checkUser);


            UserLoginResponse response;


            // Si c'est un étudiant, inclure le matricule
            if (checkUser instanceof Etudiant) {
                Etudiant etudiant = (Etudiant) checkUser;
                response = new UserLoginResponse(
                        token,
                        checkUser.getEmail(),
                        checkUser.getNom(),
                        checkUser.getPrenom(),
                        checkUser.getRole(),
                        checkUser.getImage(),
                        etudiant.getMatricule()
                );
            } else {
                // Pour les autres types d'utilisateurs (comme VIGILE)
                response = new UserLoginResponse(
                        token,
                        checkUser.getEmail(),
                        checkUser.getNom(),
                        checkUser.getPrenom(),
                        checkUser.getRole(),
                        checkUser.getImage(),
                        null
                );
            }

            return ResponseEntity.ok()
                    .header(HttpHeaders.CACHE_CONTROL, "no-store")
                    .body(response);
        } else {
            System.out.println("FAILED !!!");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect password");
        }
    }
}
