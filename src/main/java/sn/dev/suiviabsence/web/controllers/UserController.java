package sn.dev.suiviabsence.web.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import sn.dev.suiviabsence.web.dto.response.UserResponseDto;

@Tag(name = "User", description = "API pour gérer les utilisateurs")
public interface UserController {

    @Operation(
        summary = "Obtenir l'utilisateur connecté",
        description = "Retourne les informations de l'utilisateur actuellement connecté"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Informations de l'utilisateur récupérées avec succès"
    )
    @ApiResponse(
        responseCode = "401",
        description = "Non authentifié"
    )
    ResponseEntity<UserResponseDto> getCurrentUser();
} 