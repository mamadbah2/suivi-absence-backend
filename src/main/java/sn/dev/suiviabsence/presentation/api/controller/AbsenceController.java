package sn.dev.suiviabsence.presentation.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.dev.suiviabsence.presentation.api.dto.request.AbsenceRequestDto;
import sn.dev.suiviabsence.presentation.api.dto.response.AbsenceSimpleResponseDto;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/absences")
public interface AbsenceController {

  @GetMapping
  ResponseEntity<List<AbsenceSimpleResponseDto>> getAllAbsences();

  @GetMapping("/filtre/{presence}/{classe}")
  ResponseEntity<AbsenceSimpleResponseDto> filterAbsence(
      @PathVariable String presence,
      @PathVariable String classe);

  @PostMapping("/validate")
  ResponseEntity<AbsenceSimpleResponseDto> validateJustification(
      @RequestBody AbsenceRequestDto absenceRequestDto);

  @GetMapping("/classe/{classe}")
  ResponseEntity<List<AbsenceSimpleResponseDto>> getAbsencesByClasse(
      @PathVariable String classe);

  @PutMapping("/justification")
  ResponseEntity<Map<String, Object>> updateJustification(
      @RequestBody AbsenceRequestDto absenceRequestDto);
}