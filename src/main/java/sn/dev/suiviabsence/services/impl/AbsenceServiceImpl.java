package sn.dev.suiviabsence.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.data.entities.Cours;
import sn.dev.suiviabsence.data.entities.Etudiant;
import sn.dev.suiviabsence.data.enums.Status;
import sn.dev.suiviabsence.data.repositories.AbsenceRepository;
import sn.dev.suiviabsence.data.repositories.CoursRepository;
import sn.dev.suiviabsence.data.repositories.EtudiantRepository;
import sn.dev.suiviabsence.mobile.dto.response.AbsenceMobileSimpleResponse;
import sn.dev.suiviabsence.mobile.dto.response.PointageEtudiantResponse;
import sn.dev.suiviabsence.services.AbsenceService;
import sn.dev.suiviabsence.web.dto.requests.AbsenceRequestDto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AbsenceServiceImpl implements AbsenceService {

    private final EtudiantRepository etudiantRepository;
    private final CoursRepository coursRepository;

    @Autowired
    private AbsenceRepository absenceRepository;


    @Override
    public List<AbsenceMobileSimpleResponse> getPremiersEtudiantsDuJour(String date) {
        String dateAujourdhui = java.time.LocalDate.now().toString();
        List<Cours> coursList = coursRepository.findByDate(date);

        List<AbsenceMobileSimpleResponse> resultats = new ArrayList<>();

        for (Cours cours : coursList) {
            List<Etudiant> etudiants = etudiantRepository.findByClasseId(cours.getClasse().getId());
            for (Etudiant e : etudiants) {
                AbsenceMobileSimpleResponse dto = new AbsenceMobileSimpleResponse();
                dto.setNom(e.getNom());
                dto.setPrenom(e.getPrenom());
                dto.setClasse(cours.getClasse().getNom());
                dto.setModule(cours.getModule().getNom());
                dto.setHeureDebut(cours.getHeureDebut());
                dto.setHeureFin(cours.getHeureFin());
                resultats.add(dto);

                if (resultats.size() >= 5) return resultats;
            }
        }

        return resultats;
    }

    @Override
    public Optional<PointageEtudiantResponse> rechercherEtudiantPourCours(String matricule) {
        Optional<Etudiant> etudiantOpt = etudiantRepository.findByMatricule(matricule);
        if (etudiantOpt.isEmpty()) return Optional.empty();

        Etudiant etudiant = etudiantOpt.get();

        // Récupérer les absences de l'étudiant pour la date donnée
        List<Absence> absences = absenceRepository.findByEtudiantId(etudiant.getId());

        if (absences.isEmpty()) return Optional.empty();

        Absence absence = absences.get(0); // On suppose 1 seul cours ce jour

        PointageEtudiantResponse dto = new PointageEtudiantResponse();
        dto.setMatricule(etudiant.getMatricule());
        dto.setNom(etudiant.getNom());
        dto.setPrenom(etudiant.getPrenom());
        dto.setCoursNom(absence.getCours().getModule().getNom());
        dto.setHeureDebut(absence.getCours().getHeureDebut());
        dto.setHeureFin(absence.getCours().getHeureFin());

        return Optional.of(dto);
    }

    @Override
    public ResponseEntity<String> pointerEtudiant(String matricule) {
        Optional<Etudiant> etudiantOpt = etudiantRepository.findByMatricule(matricule);
        if (etudiantOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Étudiant non trouvé.");
        }

        Etudiant etudiant = etudiantOpt.get();
        List<Absence> absences = absenceRepository.findByEtudiantId(etudiant.getId());

        if (absences.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun cours pour cet étudiant à cette date.");
        }

        Absence absence = absences.get(0); // On suppose 1 seul cours pour la date
        LocalTime maintenant = LocalTime.now();

        LocalTime heureDebut = LocalTime.parse(absence.getCours().getHeureDebut()); // ex. "08:00"
        LocalTime heureFin = LocalTime.parse(absence.getCours().getHeureFin());     // ex. "10:00"

        Status nouveauStatut;

        if (maintenant.isBefore(heureFin)) {
            if (maintenant.isAfter(heureDebut)) {
                nouveauStatut = Status.RETARD;
            } else {
                nouveauStatut = Status.PRESENT;
            }
        } else {
            nouveauStatut = Status.ABSENT;
        }

        absence.setStatus(nouveauStatut.name());
        absenceRepository.save(absence);

        return ResponseEntity.ok("Statut de " + etudiant.getPrenom() + " " + etudiant.getNom() + " mis à jour : " + nouveauStatut);
    }

    @Override
    public Map<String, Object> validerJustification(AbsenceRequestDto absenceRequestDto) {
        Map<String, Object> response = new HashMap<>();
        // Recherche de l'absence par ID (ou autre critère selon le DTO)
        if (absenceRequestDto.getId() == "") {
            response.put("success", false);
            response.put("message", "ID d'absence manquant.");
            return response;
        }
        Optional<Absence> optionalAbsence = absenceRepository.findById(String.valueOf(absenceRequestDto.getId()));
        if (optionalAbsence.isEmpty()) {
            response.put("success", false);
            response.put("message", "Absence non trouvée.");
            return response;
        }
        Absence absence = optionalAbsence.get();
        // Mettre à jour le statut de la justification
        absence.setStatus("JUSTIFIE"); //
        absenceRepository.save(absence);

        response.put("success", true);
        response.put("message", "Justification validée avec succès.");
        response.put("absence", absence);
        return response;
    }

    @Override
    public Page<Absence> getAllAbsences(Pageable pageable) {
        return absenceRepository.findAll(pageable);
    }
}
