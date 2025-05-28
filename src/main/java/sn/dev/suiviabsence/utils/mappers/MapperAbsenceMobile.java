package sn.dev.suiviabsence.utils.mappers;

import lombok.NoArgsConstructor;
import sn.dev.suiviabsence.data.entities.Absence;

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
