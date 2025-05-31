package sn.dev.suiviabsence.web.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.mobile.controllers.AbsenceController;
import sn.dev.suiviabsence.services.AbsenceService;
import sn.dev.suiviabsence.web.dto.requests.AbsenceRequestDto;
import sn.dev.suiviabsence.web.dto.response.AbsenceSimpleResponseDto;

import java.util.List;
import java.util.Map;

@RestController
public class AbsenceControllerImpl implements AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    public ResponseEntity<List<AbsenceSimpleResponseDto>> getAllAbsences() {
        // Implementation here
        return null;
    }

    public ResponseEntity<Absence> filterAbsence(String presence, String classe) {
        // Implementation here
        return null;
    }

    public ResponseEntity<Map<String, Object>> validateJustification(AbsenceRequestDto absenceRequestDto) {
        // Implementation here
        return null;
    }

    public ResponseEntity<List<Absence>> getAbsenceByClasse(String classe) {
        // Implementation here
        return null;
    }

    public ResponseEntity<Map<String, Object>> updateJustification(AbsenceRequestDto absenceRequestDto) {
        // Implementation here
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
    public ResponseEntity rechercherEtudiantPourCours(String param) {
        // Implementation here
        return null;
    }

    @Override
    public ResponseEntity getPremiers(String param) {
        // Implementation here
        return null;
    }

    @Override
    public ResponseEntity pointerEtudiant(String param) {
        // Implementation here
        return null;
    }
}