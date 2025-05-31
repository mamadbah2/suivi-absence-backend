package sn.dev.suiviabsence.core.mapper;

import sn.dev.suiviabsence.core.domain.Etudiant;
import sn.dev.suiviabsence.core.domain.Classe;

public class EtudiantDomainMapper {

  public static Etudiant toDomain(sn.dev.suiviabsence.data.entities.Etudiant entity) {
    if (entity == null)
      return null;
    Etudiant etudiant = new Etudiant();
    etudiant.setId(entity.getId());
    etudiant.setNom(entity.getNom());
    etudiant.setPrenom(entity.getPrenom());

    if (entity.getClasse() != null) {
      Classe classe = new Classe();
      classe.setNom(entity.getClasse());
      etudiant.setClasse(classe);
    }

    return etudiant;
  }

  public static sn.dev.suiviabsence.data.entities.Etudiant toEntity(Etudiant domain) {
    if (domain == null)
      return null;
    return sn.dev.suiviabsence.data.entities.Etudiant.builder()
        .id(domain.getId())
        .nom(domain.getNom())
        .prenom(domain.getPrenom())
        .classe(domain.getClasse() != null ? domain.getClasse().getNom() : null)
        .build();
  }
}