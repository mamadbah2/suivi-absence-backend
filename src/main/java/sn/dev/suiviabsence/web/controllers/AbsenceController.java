package sn.dev.suiviabsence.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.web.dto.requests.AbsenceRequestDto;
import sn.dev.suiviabsence.web.dto.response.AbsenceSimpleResponseDto;

import java.util.List;
import java.util.Map;

@RequestMapping("/absences")
public interface AbsenceController {

    @GetMapping("/")
    ResponseEntity<List<AbsenceSimpleResponseDto>> getAllAbsences();

    @GetMapping("/filtre/{presence}/{classe}")
    ResponseEntity<Absence> filterAbsence(@PathVariable String presence, String classe);

    @PostMapping("/validate")
    ResponseEntity<Map<String, Object>>validateJustification(@RequestBody AbsenceRequestDto absenceRequestDto);

    @GetMapping("/absent/{classe}")
    ResponseEntity<List<Absence>> getAbsenceByClasse(@PathVariable String classe);

    @PutMapping("/update/jutification")
    ResponseEntity<Map<String, Object>> updateJustification(@RequestBody AbsenceRequestDto absenceRequestDto);
}
