package sn.dev.suiviabsence.utils.mappers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.web.dto.response.AbsenceMobileSimpleResponse;
import sn.dev.suiviabsence.web.dto.response.AbsenceSimpleResponseDto;
 @NoArgsConstructor
public class MapperAbsenceMobile {

    public static AbsenceMobileSimpleResponse toDto(Absence absence) {
        return new AbsenceMobileSimpleResponse(
                absence.getCours().getModule().getNom(),
                absence.getCours().getHeureDebut(),
                absence.getCours().getHeureFin(),
                absence.getJustification(),
                absence.getStatus()
        );
    }

}
