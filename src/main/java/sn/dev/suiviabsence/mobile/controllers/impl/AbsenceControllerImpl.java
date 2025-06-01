package sn.dev.suiviabsence.mobile.controllers.impl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.mobile.controllers.AbsenceController;
import sn.dev.suiviabsence.mobile.dto.response.AbsenceMobileSimpleResponse;
import sn.dev.suiviabsence.mobile.dto.response.PointageEtudiantResponse;
import sn.dev.suiviabsence.services.AbsenceService;
import sn.dev.suiviabsence.utils.mappers.MapperAbsenceMobile;

import java.util.List;
import java.util.Optional;

@RestController("mobileAbsenceController")
@AllArgsConstructor
@Slf4j
@Tag(name = "Absences Mobile", description = "Gestion des absences via interface mobile - Réservé aux vigiles")
@SecurityRequirement(name = "bearerAuth")
public class AbsenceControllerImpl implements AbsenceController {

    private final AbsenceService absenceService;

    @Override
    @Operation(
            summary = "Récupérer les premiers étudiants du jour",
            description = "Retourne la liste des premiers étudiants présents pour une date donnée. Accessible uniquement aux vigiles."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Liste des étudiants récupérée avec succès",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AbsenceMobileSimpleResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = "Aucun étudiant trouvé pour cette date"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Non authentifié - Token JWT requis"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Accès refusé - Rôle VIGILE requis"
            )
    })
    public ResponseEntity<List<AbsenceMobileSimpleResponse>> getPremiers(
            @Parameter(
                    description = "Date au format YYYY-MM-DD. Si non spécifiée, utilise la date courante",
                    example = "2024-01-15",
                    required = false
            )
            String date) {
        List<AbsenceMobileSimpleResponse> etudiants = absenceService.getPremiersEtudiantsDuJour(date);
        if (etudiants.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(etudiants);
    }

    @Override
    @Operation(
            summary = "Rechercher un étudiant pour un cours",
            description = "Recherche un étudiant par son matricule pour effectuer un pointage. Retourne les informations de l'étudiant et du cours."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Étudiant trouvé",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PointageEtudiantResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Étudiant non trouvé avec ce matricule"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Non authentifié"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Accès refusé - Rôle VIGILE requis"
            )
    })
    public ResponseEntity<PointageEtudiantResponse> rechercherEtudiantPourCours(
            @Parameter(
                    description = "Matricule de l'étudiant à rechercher",
                    example = "ESP2024001",
                    required = true
            )
            String matricule) {
        Optional<PointageEtudiantResponse> dto = absenceService.rechercherEtudiantPourCours(matricule);
        return dto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    @Operation(
            summary = "Pointer un étudiant",
            description = "Enregistre la présence d'un étudiant pour le cours en cours. Marque l'étudiant comme présent."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Pointage effectué avec succès",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = String.class, example = "Étudiant pointé avec succès")
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erreur lors du pointage (étudiant déjà pointé, cours non trouvé, etc.)"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Étudiant non trouvé"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Non authentifié"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Accès refusé - Rôle VIGILE requis"
            )
    })
    public ResponseEntity<String> pointerEtudiant(
            @Parameter(
                    description = "Matricule de l'étudiant à pointer",
                    example = "ESP2024001",
                    required = true
            )
            String matricule) {
        return absenceService.pointerEtudiant(matricule);
    }

    @Override
    public ResponseEntity<Page<AbsenceMobileSimpleResponse>> getAllAbsences(int page, int size) {
        Page<Absence> absences = absenceService.getAllAbsences(PageRequest.of(page, size));
        Page<AbsenceMobileSimpleResponse> response = absences.map(MapperAbsenceMobile::toDto);
        return ResponseEntity.ok(response);
    }

//    @Override
//    public ResponseEntity<Map<String, Object>> updateJustification(AbsenceRequestDto absenceRequestDto) {
//        return null;
//    }
}
