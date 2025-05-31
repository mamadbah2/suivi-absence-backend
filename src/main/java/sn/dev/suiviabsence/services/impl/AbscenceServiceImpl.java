package sn.dev.suiviabsence.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.dev.suiviabsence.dto.requests.AbsenceRequest;
import sn.dev.suiviabsence.dto.responses.AbsenceResponse;
import sn.dev.suiviabsence.exceptions.NotFoundException;
import sn.dev.suiviabsence.models.*;
import sn.dev.suiviabsence.repositories.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AbsenceServiceImpl implements AbsenceService {

    private final AbsenceRepository absenceRepository;
    private final EtudiantRepository etudiantRepository;
    private final CoursRepository coursRepository;

    @Override
    public AbsenceResponse creerAbsence(AbsenceRequest request) {
        // Validation des entités
        Etudiant etudiant = etudiantRepository.findById(request.getEtudiantId())
                .orElseThrow(() -> new NotFoundException("Étudiant non trouvé"));
        
        Cours cours = coursRepository.findById(request.getCoursId())
                .orElseThrow(() -> new NotFoundException("Cours non trouvé"));

        // Création et sauvegarde
        Absence absence = new Absence();
        absence.setEtudiant(etudiant);
        absence.setCours(cours);
        absence.setDateAbsence(request.getDateAbsence());
        absence.setStatut("NON_JUSTIFIEE");
        absence.setDateCreation(LocalDateTime.now());

        Absence savedAbsence = absenceRepository.save(absence);

        // Mapping manuel vers DTO
        return mapToAbsenceResponse(savedAbsence);
    }

    @Override
    public List<AbsenceResponse> getAbsencesByEtudiantId(Long etudiantId) {
        if (!etudiantRepository.existsById(etudiantId)) {
            throw new NotFoundException("Étudiant non trouvé");
        }

        return absenceRepository.findByEtudiantId(etudiantId)
                .stream()
                .map(this::mapToAbsenceResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AbsenceResponse validerAbsence(Long absenceId, String statut) {
        Absence absence = absenceRepository.findById(absenceId)
                .orElseThrow(() -> new NotFoundException("Absence non trouvée"));

        absence.setStatut(statut);
        absence.setDateValidation(LocalDateTime.now());

        Absence updatedAbsence = absenceRepository.save(absence);
        return mapToAbsenceResponse(updatedAbsence);
    }

    // Méthode de mapping manuel
    private AbsenceResponse mapToAbsenceResponse(Absence absence) {
        AbsenceResponse response = new AbsenceResponse();
        response.setId(absence.getId());
        
        if (absence.getEtudiant() != null) {
            response.setEtudiantNom(absence.getEtudiant().getNomComplet());
            response.setEtudiantMatricule(absence.getEtudiant().getMatricule());
        }
        
        if (absence.getCours() != null) {
            response.setCoursNom(absence.getCours().getIntitule());
            response.setCoursCode(absence.getCours().getCode());
        }
        
        response.setDateAbsence(absence.getDateAbsence());
        response.setStatut(absence.getStatut());
        response.setJustificationUrl(absence.getJustificationUrl());
        response.setDateCreation(absence.getDateCreation());
        response.setDateValidation(absence.getDateValidation());
        
        if (absence.getValidateur() != null) {
            response.setValidateurNom(absence.getValidateur().getNomComplet());
        }
        
        return response;
        }
}
