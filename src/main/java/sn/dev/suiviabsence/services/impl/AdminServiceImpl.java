package sn.dev.suiviabsence.services.impl;

import org.springframework.stereotype.Service;
import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.services.AbsenceService;

import java.util.List;
@Service
public class AdminServiceImpl implements AbsenceService {
    @Override
    public List<Absence> getAbsentOuRetard(String filtre) {
        return List.of();
    }

    @Override
    public void validateJustification(Absence absence) {

    }

    @Override
    public List<Absence> getAbsentByClasse(String nomClasse) {
        return List.of();
    }
}
