package sn.dev.suiviabsence.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.data.entities.Cours;
import sn.dev.suiviabsence.data.entities.Etudiant;
import sn.dev.suiviabsence.data.repositories.AbsenceRepository;
import sn.dev.suiviabsence.services.DerniersPointagesService;
import sn.dev.suiviabsence.web.dto.response.DernierPointageResponseDto;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DerniersPointagesServiceImpl implements DerniersPointagesService {

  private final AbsenceRepository absenceRepository;
  private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm");

  @Override
  public List<DernierPointageResponseDto> getDerniersPointages() {
    List<Absence> derniersPointages = absenceRepository.findAll(
        PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "date"))).getContent();

    return derniersPointages.stream()
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  private DernierPointageResponseDto mapToDto(Absence absence) {
    Etudiant etudiant = absence.getEtudiant();
    Cours cours = absence.getCours();

    return DernierPointageResponseDto.builder()
        .id(absence.getId())
        .nom(etudiant != null ? etudiant.getNom() : null)
        .prenom(etudiant != null ? etudiant.getPrenom() : null)
        .classe(etudiant != null ? etudiant.getClasse() : null)
        .module(cours != null ? cours.getModule() : null)
        .date(absence.getDate())
        .heure(TIME_FORMAT.format(absence.getDate()))
        .status(absence.getStatus())
        .justification(absence.getJustification())
        .justificatif(absence.getJustificatif())
        .build();
  }
}