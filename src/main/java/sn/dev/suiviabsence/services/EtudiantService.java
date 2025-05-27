package sn.dev.suiviabsence.services;

import sn.dev.suiviabsence.data.entities.Etudiant;

public interface EtudiantService {

    Etudiant getEtudiantByMatricule(String matricule);
}
