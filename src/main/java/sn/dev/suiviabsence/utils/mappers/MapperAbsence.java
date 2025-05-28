package sn.dev.suiviabsence.utils.mappers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.web.dto.requests.AbsenceRequestDto;
import sn.dev.suiviabsence.web.dto.response.AbsenceSimpleResponseDto;

@AllArgsConstructor
@NoArgsConstructor
public class MapperAbsence {

    public static AbsenceSimpleResponseDto toDto(Absence absence) {
        return new AbsenceSimpleResponseDto(
                absence.getEtudiant().getMatricule(),
                absence.getEtudiant().getNom(),
                absence.getEtudiant().getPrenom(),
                absence.getCours().getClasse().getNom(),
                absence.getCours().getModule().getNom(),
                absence.getDate(),
                absence.getHeure(),
                absence.getJustification(),
                absence.getStatus()
        );
    }

    //a coder
    public static Absence toEntity(AbsenceRequestDto absence) {
        Absence absenceEntity = new Absence();
        return absenceEntity;
    }

}
