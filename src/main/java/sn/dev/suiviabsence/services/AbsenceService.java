package sn.dev.suiviabsence.services;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.mobile.dto.response.AbsenceMobileSimpleResponse;
import sn.dev.suiviabsence.mobile.dto.response.EtudiantAbsencesResponse;
import sn.dev.suiviabsence.mobile.dto.response.PointageEtudiantResponse;
import sn.dev.suiviabsence.web.dto.requests.AbsenceRequestDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AbsenceService {
    List<AbsenceMobileSimpleResponse> getPremiersEtudiantsDuJour();
    Optional<PointageEtudiantResponse> rechercherEtudiantPourCours(String matricule);
    ResponseEntity<String> pointerEtudiant(String matricule);
    Map<String, Object> validerJustification(AbsenceRequestDto absenceRequestDto);
    Page<Absence> getAllAbsences(Pageable pageable);
    
    /**
     * Récupère toutes les absences et retards d'un étudiant spécifique
     * @param matricule Le matricule de l'étudiant
     * @return Les informations de l'étudiant et ses absences/retards
     */
    Optional<EtudiantAbsencesResponse> getAbsencesEtudiant(String matricule);
    
    /**
     * Met à jour uniquement la justification d'une absence
     * @param absenceRequestDto Contient l'ID de l'absence et la nouvelle justification
     * @return Un Map contenant le résultat de l'opération (succès ou échec)
     */
    Map<String, Object> updateJustification(AbsenceRequestDto absenceRequestDto);
    
    /**
     * Soumet une justification avec des images pour une absence
     * @param absenceId ID de l'absence à justifier
     * @param commentaire Texte de justification
     * @param motif Motif de la justification
     * @param imageUrls Liste des URLs des images justificatives
     * @return Un Map contenant le résultat de l'opération et l'absence mise à jour
     */
    Map<String, Object> soumettreJustificationAvecImages(String absenceId, String commentaire, String motif, List<String> imageUrls);
}
