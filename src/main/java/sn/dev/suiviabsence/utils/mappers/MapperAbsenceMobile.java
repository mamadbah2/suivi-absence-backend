package sn.dev.suiviabsence.utils.mappers;

import lombok.NoArgsConstructor;
import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.mobile.dto.response.AbsenceMobileSimpleResponse;

@NoArgsConstructor
public class MapperAbsenceMobile {

    public static AbsenceMobileSimpleResponse toDto(Absence absence) {
        return new AbsenceMobileSimpleResponse(
                absence.getEtudiant().getMatricule(), // Ajout du matricule de l'étudiant
                absence.getEtudiant().getNom(),
                absence.getEtudiant().getPrenom(),
                absence.getCours().getClasse().getNom(),
                absence.getCours().getModule().getNom(),
                absence.getCours().getHeureDebut(),
                absence.getCours().getHeureFin(),
                absence.getStatus()
        );
    }

}
