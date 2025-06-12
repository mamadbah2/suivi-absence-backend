package sn.dev.suiviabsence.services.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.data.entities.Etudiant;
import sn.dev.suiviabsence.data.enums.Status;
import sn.dev.suiviabsence.data.repositories.AbsenceRepository;
import sn.dev.suiviabsence.data.repositories.EtudiantRepository;
import sn.dev.suiviabsence.mobile.dto.response.AbsenceMobileSimpleResponse;
import sn.dev.suiviabsence.mobile.dto.response.EtudiantAbsencesResponse;
import sn.dev.suiviabsence.mobile.dto.response.PointageEtudiantResponse;
import sn.dev.suiviabsence.services.AbsenceService;
import sn.dev.suiviabsence.utils.mappers.MapperAbsenceMobile;
import sn.dev.suiviabsence.web.dto.requests.AbsenceRequestDto;

@Service
@Primary
@RequiredArgsConstructor
public class AbsenceMobileServiceImpl implements AbsenceService {

    private final AbsenceRepository absenceRepository;
    private final EtudiantRepository etudiantRepository;

    @Override
    public List<AbsenceMobileSimpleResponse> getPremiersEtudiantsDuJour() {
        // Si date non fournie, utiliser la date du jour
        String dateAujourdhui = LocalDate.now().toString();

        // Récupérer toutes les absences pour la date donnée
        List<Absence> toutesLesAbsences = absenceRepository.findAll().stream()
                .filter(absence -> absence.getDate().equals(dateAujourdhui))
                .collect(Collectors.toList());

        // Filtrer les absences où l'étudiant a pointé (PRESENT ou RETARD)
        List<Absence> absencesPointees = toutesLesAbsences.stream()
                .filter(absence -> absence.getStatus() == Status.PRESENT || absence.getStatus() == Status.RETARD)
                .sorted(Comparator.comparing(Absence::getHeure).reversed()) // Tri par heure de pointage décroissant (le plus récent d'abord)
                .limit(5) // Limiter aux 5 derniers pointages
                .collect(Collectors.toList());

        // Utiliser le mapper pour convertir les absences en DTO
        return absencesPointees.stream()
                .map(MapperAbsenceMobile::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PointageEtudiantResponse> rechercherEtudiantPourCours(String matricule) {
        Optional<Etudiant> etudiantOpt = etudiantRepository.findByMatricule(matricule);
        if (etudiantOpt.isEmpty()) return Optional.empty();

        Etudiant etudiant = etudiantOpt.get();
        String dateAujourdhui = LocalDate.now().toString();

        // Récupérer les absences de l'étudiant pour la date du jour
        List<Absence> absences = absenceRepository.findByEtudiantId(etudiant.getId())
                .stream()
                .filter(absence -> absence.getDate().equals(dateAujourdhui))
                .collect(Collectors.toList());

        if (absences.isEmpty()) return Optional.empty();

        // Prendre la première absence du jour
        Absence absence = absences.get(0);

        PointageEtudiantResponse dto = new PointageEtudiantResponse();
        dto.setMatricule(etudiant.getMatricule());
        dto.setNom(etudiant.getNom());
        dto.setPrenom(etudiant.getPrenom());
        dto.setCoursNom(absence.getCours().getModule().getNom());
        dto.setHeureDebut(absence.getCours().getHeureDebut());
        dto.setHeureFin(absence.getCours().getHeureFin());
        dto.setStatus(absence.getStatus());

        return Optional.of(dto);
    }

    @Override
    public ResponseEntity<String> pointerEtudiant(String matricule) {
        Optional<Etudiant> etudiantOpt = etudiantRepository.findByMatricule(matricule);
        if (etudiantOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Étudiant non trouvé.");
        }

        Etudiant etudiant = etudiantOpt.get();
        String dateAujourdhui = LocalDate.now().toString();

        // Récupérer les absences de l'étudiant pour la date du jour
        List<Absence> absences = absenceRepository.findByEtudiantId(etudiant.getId())
                .stream()
                .filter(absence -> absence.getDate().equals(dateAujourdhui))
                .collect(Collectors.toList());

        if (absences.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun cours pour cet étudiant aujourd'hui.");
        }

        // Mettre à jour le statut pour chaque absence de l'étudiant aujourd'hui
        for (Absence absence : absences) {
            LocalTime maintenant = LocalTime.now();
            LocalTime heureDebut = LocalTime.parse(absence.getCours().getHeureDebut());
            LocalTime heureFin = LocalTime.parse(absence.getCours().getHeureFin());

            Status nouveauStatut;
            if (maintenant.isBefore(heureFin)) {
                if (maintenant.isAfter(heureDebut)) {
                    nouveauStatut = Status.RETARD;
                } else {
                    nouveauStatut = Status.PRESENT;
                }
            } else {
                nouveauStatut = Status.ABSENT; // Arrivé après la fin du cours = toujours absent
            }

            // Mettre à jour l'heure de pointage
            absence.setHeure(LocalTime.now().toString());
            absence.setStatus(nouveauStatut);
            absenceRepository.save(absence);
        }

        return ResponseEntity.ok("Statut de " + etudiant.getPrenom() + " " + etudiant.getNom() + " mis à jour.");
    }

    @Override
    public Map<String, Object> validerJustification(AbsenceRequestDto absenceRequestDto) {
        Map<String, Object> response = new HashMap<>();
        if (absenceRequestDto.getId() == null) {
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
        absence.setStatus("JUSTIFIE"); // ou autre valeur selon votre logique métier
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

    @Override
    public Optional<EtudiantAbsencesResponse> getAbsencesEtudiant(String matricule) {
        // Récupérer l'étudiant par son matricule
        Optional<Etudiant> etudiantOpt = etudiantRepository.findByMatricule(matricule);
        if (etudiantOpt.isEmpty()) {
            return Optional.empty();
        }

        Etudiant etudiant = etudiantOpt.get();
        
        // Récupérer toutes les absences de cet étudiant
        List<Absence> absences = absenceRepository.findByEtudiantId(etudiant.getId());
        
        // Exclure les absences avec status PRESENT (on ne veut que les absences et retards)
        absences = absences.stream()
                .filter(absence -> absence.getStatus() == Status.ABSENT || absence.getStatus() == Status.RETARD)
                .collect(Collectors.toList());
        
        // Créer la réponse
        EtudiantAbsencesResponse response = new EtudiantAbsencesResponse();
        response.setMatricule(etudiant.getMatricule());
        response.setNom(etudiant.getNom());
        response.setPrenom(etudiant.getPrenom());
        response.setClasse(etudiant.getClasse() != null ? etudiant.getClasse().getNom() : "Non définie");
        
        // Convertir les absences en DTO
        List<EtudiantAbsencesResponse.AbsenceDetail> absenceDetails = absences.stream()
                .map(absence -> {
                    EtudiantAbsencesResponse.AbsenceDetail detail = new EtudiantAbsencesResponse.AbsenceDetail();
                    detail.setDate(absence.getDate());
                    detail.setHeureDebut(absence.getCours().getHeureDebut());
                    detail.setHeureFin(absence.getCours().getHeureFin());
                    detail.setModule(absence.getCours().getModule().getNom());
                    detail.setProfesseur(absence.getCours().getModule().getNomProf());
                    detail.setStatus(absence.getStatus());
                    detail.setJustification(absence.getJustification());
                    detail.setHeurePointage(absence.getHeure());
                    return detail;
                })
                .collect(Collectors.toList());
        
        response.setAbsences(absenceDetails);
        
        return Optional.of(response);
    }
}
