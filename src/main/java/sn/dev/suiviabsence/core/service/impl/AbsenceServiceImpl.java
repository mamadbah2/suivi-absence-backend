package sn.dev.suiviabsence.core.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import sn.dev.suiviabsence.core.domain.Absence;
import sn.dev.suiviabsence.core.service.AbsenceService;
import sn.dev.suiviabsence.infrastructure.persistence.AbsenceRepository;

@Service
@RequiredArgsConstructor
public class AbsenceServiceImpl implements AbsenceService {

  private final AbsenceRepository absenceRepository;

  @Override
  public List<Absence> getAllAbsences() {
    return absenceRepository.findAll();
  }

  @Override
  public Absence filterAbsence(String presence, String classe) {
    return absenceRepository.findByStatusAndCours_Classe_Nom(presence, classe);
  }

  @Override
  public Absence validateJustification(Absence absence) {
    return absenceRepository.save(absence);
  }

  @Override
  public List<Absence> getAbsencesByClasse(String classe) {
    return absenceRepository.findByCours_Classe_Nom(classe);
  }

  @Override
  public Absence updateJustification(Absence absence) {
    return absenceRepository.save(absence);
  }
}