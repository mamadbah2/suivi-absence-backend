package sn.dev.suiviabsence.core.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import sn.dev.suiviabsence.core.domain.Absence;
import sn.dev.suiviabsence.presentation.api.dto.response.DernierPointageDto;
import sn.dev.suiviabsence.presentation.api.dto.response.AbsenceSimpleResponseDto;
import sn.dev.suiviabsence.presentation.api.dto.request.AbsenceRequestDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapperAbsence {

  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

  public static DernierPointageDto toDernierPointageDto(Absence absence) {
    Date parsedDate = null;
    try {
      parsedDate = DATE_FORMAT.parse(absence.getDate());
    } catch (ParseException e) {
      parsedDate = new Date();
    }

    return DernierPointageDto.builder()
        .id(absence.getId())
        .nom(absence.getEtudiant().getNom())
        .prenom(absence.getEtudiant().getPrenom())
        .classe(absence.getCours().getClasse().getNom())
        .module(absence.getCours().getModule().getNom())
        .date(parsedDate)
        .heure(absence.getHeure())
        .status(absence.getStatus())
        .justification(absence.getJustification())
        .justificatif(absence.getJustificatif())
        .build();
  }

  public static AbsenceSimpleResponseDto toSimpleDto(Absence absence) {
    return new AbsenceSimpleResponseDto(
        absence.getEtudiant().getMatricule(),
        absence.getEtudiant().getNom(),
        absence.getEtudiant().getPrenom(),
        absence.getCours().getClasse().getNom(),
        absence.getCours().getModule().getNom(),
        absence.getDate(),
        absence.getHeure(),
        absence.getJustification(),
        absence.getStatus());
  }

  public static Absence toEntity(AbsenceRequestDto absenceDto) {
    Absence absence = new Absence();
    absence.setDate(absenceDto.getDate());
    absence.setHeure(absenceDto.getHeure());
    absence.setJustification(absenceDto.getJustification());
    absence.setStatus(absenceDto.getStatus());
    return absence;
  }
}