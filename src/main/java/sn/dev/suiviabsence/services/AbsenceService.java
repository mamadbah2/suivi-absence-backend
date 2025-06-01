package sn.dev.suiviabsence.services;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.data.domain.Pageable;

import org.springframework.web.multipart.MultipartFile;
import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.mobile.dto.response.AbsenceMobileSimpleResponse;
import sn.dev.suiviabsence.mobile.dto.response.PointageEtudiantResponse;
import sn.dev.suiviabsence.web.dto.requests.AbsenceRequestDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AbsenceService {
    List<AbsenceMobileSimpleResponse> getPremiersEtudiantsDuJour(String date);
    Optional<PointageEtudiantResponse> rechercherEtudiantPourCours(String matricule);
    ResponseEntity<String> pointerEtudiant(String matricule);
    Map<String, Object> validerJustification(AbsenceRequestDto absenceRequestDto);
    Page<Absence> getAllAbsences(Pageable pageable);
    Map<String, Object> saveJustificatif(String idAbsence, MultipartFile file);


}
