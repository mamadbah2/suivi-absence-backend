package sn.dev.suiviabsence.web.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.mobile.dto.response.AbsenceMobileSimpleResponse;
import sn.dev.suiviabsence.web.dto.requests.AbsenceRequestDto;
import sn.dev.suiviabsence.web.dto.response.AbsenceSimpleResponseDto;

import java.util.List;
import java.util.Map;

@RequestMapping("/app/absences")
public interface AbsenceController {

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/validate")
    ResponseEntity<Map<String, Object>>validerJustification(@RequestBody AbsenceRequestDto absenceRequestDto);


    @Operation(summary = "Liste de tous les absences")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list")
    ResponseEntity<Page<AbsenceSimpleResponseDto>> getAllAbsences(
            @Parameter(description = "Numéro de page pour la pagination, par défaut 0")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Taille de la page pour la pagination, par défaut 10")
            @RequestParam(defaultValue = "10") int size);

    @GetMapping("/filtre/{presence}/{classe}")
    ResponseEntity<Absence> filterAbsence(@PathVariable String presence, String classe);


    @GetMapping("/absent/{classe}")
    ResponseEntity<List<Absence>> getAbsenceByClasse(@PathVariable String classe);

    @PutMapping("/update/justification")
    ResponseEntity<Map<String, Object>> updateJustification(@RequestBody AbsenceRequestDto absenceRequestDto);


}
