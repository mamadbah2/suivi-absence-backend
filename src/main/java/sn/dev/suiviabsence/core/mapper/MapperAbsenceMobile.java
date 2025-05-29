package sn.dev.suiviabsence.core.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import sn.dev.suiviabsence.core.domain.Absence;
import sn.dev.suiviabsence.presentation.api.dto.response.AbsenceMobileSimpleResponse;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapperAbsenceMobile {

  public static AbsenceMobileSimpleResponse toDto(Absence absence) {
    return new AbsenceMobileSimpleResponse(
        absence.getCours().getModule().getNom(),
        absence.getCours().getHeureDebut(),
        absence.getCours().getHeureFin(),
        absence.getJustification(),
        absence.getStatus());
  }
}