package sn.dev.suiviabsence.services;

import sn.dev.suiviabsence.data.entities.Absence;

import java.util.List;

public interface AbsenceService {
    List<Absence> getAbsentOuRetard(String filtre);
    void validateJustification(Absence absence);
    List<Absence> getAbsentByClasse(String nomClasse);
}
