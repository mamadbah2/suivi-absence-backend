package sn.dev.suiviabsence.web.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import sn.dev.suiviabsence.web.dto.response.DernierPointageResponseDto;

import java.util.List;

@Tag(name = "Derniers Pointages", description = "API pour gérer les derniers pointages")
public interface DerniersPointagesController {

    @Operation(
        summary = "Récupérer les 5 derniers pointages",
        description = "Retourne une liste des 5 derniers pointages enregistrés"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Liste des derniers pointages récupérée avec succès"
    )
    ResponseEntity<List<DernierPointageResponseDto>> getDerniersPointages();
} 