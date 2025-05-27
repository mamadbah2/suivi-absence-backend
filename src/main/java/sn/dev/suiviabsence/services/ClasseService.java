package sn.dev.suiviabsence.services;

import sn.dev.suiviabsence.data.entities.Classe;

import java.util.List;

public interface ClasseService {
    List<Classe> getAllClasses();
    Classe getClasseById(String id);
    Classe getClasseByName(String classeName);
}
