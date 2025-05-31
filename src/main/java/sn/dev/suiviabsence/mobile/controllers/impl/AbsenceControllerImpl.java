package sn.dev.suiviabsence.mobile.controllers.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sn.dev.suiviabsence.mobile.controllers.AbsenceController;
import sn.dev.suiviabsence.mobile.dto.response.AbsenceMobileSimpleResponse;
import sn.dev.suiviabsence.mobile.dto.response.PointageEtudiantResponse;
import sn.dev.suiviabsence.services.AbsenceService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
//@RequestMapping("/absences/mobiles")
public class AbsenceControllerImpl implements AbsenceController {

    private final AbsenceService absenceService;

//    @PostConstruct
//    public void init() {
//        log.info("AbsenceControllerImpl initialisé avec le mapping : /absences/mobiles");
//    }

//    @Override
//    public ResponseEntity<List<AbsenceSimpleResponseDto>> getAllAbsences() {
//        return null;
//    }

//    @Override
//    public ResponseEntity<Absence> filterAbsence(String presence, String classe) {
//        return null;
//    }

//    @Override
//    public ResponseEntity<Map<String, Object>> validateJustification(AbsenceRequestDto absenceRequestDto) {
//        return null;
//    }

    @Override
//    @GetMapping("/premiers")
    public ResponseEntity<List<AbsenceMobileSimpleResponse>> getPremiers(String date) {
        List<AbsenceMobileSimpleResponse> etudiants = absenceService.getPremiersEtudiantsDuJour(date);
        if (etudiants.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(etudiants);
    }

    @Override
    public ResponseEntity<PointageEtudiantResponse> rechercherEtudiantPourCours(String matricule) {
        Optional<PointageEtudiantResponse> dto = absenceService.rechercherEtudiantPourCours(matricule);
        return dto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<String> pointerEtudiant(String matricule) {
        return absenceService.pointerEtudiant(matricule);
    }

//    @Override
//    public ResponseEntity<Map<String, Object>> updateJustification(AbsenceRequestDto absenceRequestDto) {
//        return null;
//    }
}
