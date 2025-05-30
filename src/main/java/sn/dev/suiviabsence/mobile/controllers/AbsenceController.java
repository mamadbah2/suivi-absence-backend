package sn.dev.suiviabsence.mobile.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.mobile.dto.response.AbsenceMobileSimpleResponse;
import sn.dev.suiviabsence.mobile.dto.response.PointageEtudiantResponse;
import sn.dev.suiviabsence.web.dto.requests.AbsenceRequestDto;
import sn.dev.suiviabsence.web.dto.response.AbsenceSimpleResponseDto;

import java.util.List;
import java.util.Map;

@RequestMapping("/absences/mobiles")
public interface AbsenceController {

//    @GetMapping("/")
//    ResponseEntity<List<AbsenceSimpleResponseDto>> getAllAbsences();

//    @GetMapping("/filtre/{presence}/{classe}")
//    ResponseEntity<Absence> filterAbsence(@PathVariable String presence, String classe);

//    @PostMapping("/validate")
//    ResponseEntity<Map<String, Object>>validateJustification(@RequestBody AbsenceRequestDto absenceRequestDto);

    @PreAuthorize("hasRole('VIGILE')")
    @GetMapping("/premiers")
    ResponseEntity<List<AbsenceMobileSimpleResponse>> getPremiers(@RequestParam String date);

    @PreAuthorize("hasRole('VIGILE')")
    @GetMapping("/rechercher")
    ResponseEntity<PointageEtudiantResponse> rechercherEtudiantPourCours(
            @RequestParam String matricule// Format : "2025-05-29"
    );

    @PreAuthorize("hasRole('VIGILE')")
    @PostMapping("/pointer")
    ResponseEntity<String> pointerEtudiant(
            @RequestParam String matricule
    );
//    @PutMapping("/update/jutification")
//    ResponseEntity<Map<String, Object>> updateJustification(@RequestBody AbsenceRequestDto absenceRequestDto);
}
