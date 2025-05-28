package sn.dev.suiviabsence.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.web.dto.response.AbsenceSimpleResponseDto;

import java.util.List;

@RequestMapping("/absences")
public interface AbsenceController {

    @GetMapping("/")
    ResponseEntity<List<AbsenceSimpleResponseDto>> getAllAbsences();

    @GetMapping("/filtre/{presence}/{classe}")
    ResponseEntity<Absence> filterAbsence(@PathVariable String presence, String classe);

    @PostMapping("/validate")
    ResponseEntity<Absence> validateJustification(Absence absence);

    @GetMapping("/absent/{classe}")
    ResponseEntity<List<Absence>> getAbsenceByClasse(@PathVariable String classe);
}
