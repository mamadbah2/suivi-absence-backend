package sn.dev.suiviabsence.presentation.api.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sn.dev.suiviabsence.core.domain.Absence;
import sn.dev.suiviabsence.core.mapper.MapperAbsence;
import sn.dev.suiviabsence.core.service.AbsenceService;
import sn.dev.suiviabsence.presentation.api.controller.AbsenceController;
import sn.dev.suiviabsence.presentation.api.dto.request.AbsenceRequestDto;
import sn.dev.suiviabsence.presentation.api.dto.response.AbsenceSimpleResponseDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AbsenceControllerImpl implements AbsenceController {

  private final AbsenceService absenceService;

  @Override
  public ResponseEntity<List<AbsenceSimpleResponseDto>> getAllAbsences() {
    log.info("Récupération de toutes les absences");
    List<AbsenceSimpleResponseDto> absences = absenceService.getAllAbsences()
        .stream()
        .map(MapperAbsence::toSimpleDto)
        .collect(Collectors.toList());
    return ResponseEntity.ok(absences);
  }

  @Override
  public ResponseEntity<AbsenceSimpleResponseDto> filterAbsence(String presence, String classe) {
    log.info("Filtrage des absences par présence: {} et classe: {}", presence, classe);
    Absence absence = absenceService.filterAbsence(presence, classe);
    return ResponseEntity.ok(MapperAbsence.toSimpleDto(absence));
  }

  @Override
  public ResponseEntity<AbsenceSimpleResponseDto> validateJustification(AbsenceRequestDto absenceRequestDto) {
    log.info("Validation de la justification d'absence");
    Absence absence = absenceService.validateJustification(MapperAbsence.toEntity(absenceRequestDto));
    return ResponseEntity.ok(MapperAbsence.toSimpleDto(absence));
  }

  @Override
  public ResponseEntity<List<AbsenceSimpleResponseDto>> getAbsencesByClasse(String classe) {
    log.info("Récupération des absences pour la classe: {}", classe);
    List<AbsenceSimpleResponseDto> absences = absenceService.getAbsencesByClasse(classe)
        .stream()
        .map(MapperAbsence::toSimpleDto)
        .collect(Collectors.toList());
    return ResponseEntity.ok(absences);
  }

  @Override
  public ResponseEntity<Map<String, Object>> updateJustification(AbsenceRequestDto absenceRequestDto) {
    log.info("Mise à jour de la justification d'absence");
    Absence updatedAbsence = absenceService.updateJustification(MapperAbsence.toEntity(absenceRequestDto));

    Map<String, Object> response = new HashMap<>();
    response.put("success", true);
    response.put("message", "Justification mise à jour avec succès");
    response.put("absence", MapperAbsence.toSimpleDto(updatedAbsence));

    return ResponseEntity.ok(response);
  }
}