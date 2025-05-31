package sn.dev.suiviabsence.core.mapper;

import sn.dev.suiviabsence.core.domain.Cours;
import sn.dev.suiviabsence.core.domain.Module;

public class CoursDomainMapper {

  public static Cours toDomain(sn.dev.suiviabsence.data.entities.Cours entity) {
    if (entity == null)
      return null;
    Cours cours = new Cours();
    cours.setId(entity.getId());

    if (entity.getModule() != null) {
      Module module = new Module();
      module.setNom(entity.getModule());
      cours.setModule(module);
    }

    return cours;
  }

  public static sn.dev.suiviabsence.data.entities.Cours toEntity(Cours domain) {
    if (domain == null)
      return null;
    return sn.dev.suiviabsence.data.entities.Cours.builder()
        .id(domain.getId())
        .module(domain.getModule() != null ? domain.getModule().getNom() : null)
        .build();
  }
}