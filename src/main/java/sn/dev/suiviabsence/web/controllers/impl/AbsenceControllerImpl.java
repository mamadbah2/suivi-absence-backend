package sn.dev.suiviabsence.web.controllers.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.utils.mappers.MapperAbsence;
import sn.dev.suiviabsence.web.controllers.AbsenceController;
import sn.dev.suiviabsence.services.AbsenceService;
import sn.dev.suiviabsence.web.dto.requests.AbsenceRequestDto;
import sn.dev.suiviabsence.web.dto.response.AbsenceSimpleResponseDto;

import java.util.List;
import java.util.Map;

@RestController("webAbsenceController")
@AllArgsConstructor
@Slf4j
public class AbsenceControllerImpl implements AbsenceController {

    private final AbsenceService absenceService;

    @Override
    public ResponseEntity<Page<AbsenceSimpleResponseDto>> getAllAbsences(int page, int size) {
        Page<Absence> absences = absenceService.getAllAbsences(PageRequest.of(page, size));
        Page<AbsenceSimpleResponseDto> response = absences.map(MapperAbsence::toDto);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Absence> filterAbsence(String presence, String classe) {
        return null;
    }

    public ResponseEntity<Map<String, Object>> validerJustification(AbsenceRequestDto absenceRequestDto) {
        Map<String, Object> result = absenceService.validerJustification(absenceRequestDto);
        if (Boolean.TRUE.equals(result.get("success"))) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }



    @Override
    public ResponseEntity<List<Absence>> getAbsenceByClasse(String classe) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> updateJustification(AbsenceRequestDto absenceRequestDto) {
        Map<String, Object> result = absenceService.updateJustification(absenceRequestDto);
        if (Boolean.TRUE.equals(result.get("success"))) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
