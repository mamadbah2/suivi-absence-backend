package sn.dev.suiviabsence.services;

import org.springframework.http.ResponseEntity;
import sn.dev.suiviabsence.mobile.dto.response.AbsenceMobileSimpleResponse;
import sn.dev.suiviabsence.mobile.dto.response.PointageEtudiantResponse;

import java.util.List;
import java.util.Optional;

public interface AbsenceService {
    List<AbsenceMobileSimpleResponse> getPremiersEtudiantsDuJour(String date);
    Optional<PointageEtudiantResponse> rechercherEtudiantPourCours(String matricule);
    ResponseEntity<String> pointerEtudiant(String matricule);


}
