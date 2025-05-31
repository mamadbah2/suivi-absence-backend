package sn.dev.suiviabsence.mobile.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.dev.suiviabsence.mobile.dto.response.AbsenceMobileSimpleResponse;
import sn.dev.suiviabsence.mobile.dto.response.PointageEtudiantResponse;

import java.util.List;

@RequestMapping("/app/absences/mobiles")
@Tag(name = "Gestion des absences (Mobile)", description = "API pour la gestion des absences via l'application mobile")
@SecurityRequirement(name = "Bearer Authentication")
public interface AbsenceController {

    @Operation(summary = "Récupérer les derniers étudiants ayant pointé", 
               description = "Retourne la liste des 10 derniers étudiants qui ont pointé leur présence ou leur retard, triés par heure de pointage décroissante")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Liste des étudiants récupérée avec succès"),
        @ApiResponse(responseCode = "204", description = "Aucun pointage trouvé"),
        @ApiResponse(responseCode = "403", description = "Accès refusé - Rôle VIGILE requis"),
        @ApiResponse(responseCode = "401", description = "Non autorisé - Token JWT manquant ou invalide")
    })
    @PreAuthorize("hasRole('VIGILE')")
    @GetMapping("/premiers")
    ResponseEntity<List<AbsenceMobileSimpleResponse>> getPremiers(
            @Parameter(description = "Date au format YYYY-MM-DD, si non fourni la date du jour sera utilisée") 
            @RequestParam String date);

    @Operation(summary = "Rechercher un étudiant pour un cours", 
               description = "Recherche un étudiant par son matricule et retourne ses informations avec son cours du jour")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Étudiant trouvé", 
                     content = @Content(schema = @Schema(implementation = PointageEtudiantResponse.class))),
        @ApiResponse(responseCode = "404", description = "Étudiant non trouvé ou pas de cours aujourd'hui"),
        @ApiResponse(responseCode = "403", description = "Accès refusé - Rôle VIGILE requis"),
        @ApiResponse(responseCode = "401", description = "Non autorisé - Token JWT manquant ou invalide")
    })
    @PreAuthorize("hasRole('VIGILE')")
    @GetMapping("/rechercher")
    ResponseEntity<PointageEtudiantResponse> rechercherEtudiantPourCours(
            @Parameter(description = "Matricule de l'étudiant (ex: ETD001)", required = true)
            @RequestParam String matricule
    );

    @Operation(summary = "Pointer la présence d'un étudiant", 
               description = "Enregistre la présence, le retard ou l'absence d'un étudiant en fonction de l'heure de pointage")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pointage effectué avec succès"),
        @ApiResponse(responseCode = "404", description = "Étudiant non trouvé ou pas de cours aujourd'hui"),
        @ApiResponse(responseCode = "403", description = "Accès refusé - Rôle VIGILE requis"),
        @ApiResponse(responseCode = "401", description = "Non autorisé - Token JWT manquant ou invalide")
    })
    @PreAuthorize("hasRole('VIGILE')")
    @PostMapping("/pointer")
    ResponseEntity<String> pointerEtudiant(
            @Parameter(description = "Matricule de l'étudiant (ex: ETD001)", required = true)
            @RequestParam String matricule
    );

    @Operation(summary = "Liste de tous les absences")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list")
    ResponseEntity<Page<AbsenceMobileSimpleResponse>> getAllAbsences(
            @Parameter(description = "Numéro de page pour la pagination, par défaut 0")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Taille de la page pour la pagination, par défaut 10")
            @RequestParam(defaultValue = "10") int size
    );

}
