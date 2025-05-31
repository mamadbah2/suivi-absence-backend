package sn.dev.suiviabsence.core.service;

import sn.dev.suiviabsence.core.domain.Absence;
import java.util.List;

public interface AbsenceService {
  List<Absence> getAllAbsences();

  Absence filterAbsence(String presence, String classe);

  Absence validateJustification(Absence absence);

  List<Absence> getAbsencesByClasse(String classe);

  Absence updateJustification(Absence absence);
}