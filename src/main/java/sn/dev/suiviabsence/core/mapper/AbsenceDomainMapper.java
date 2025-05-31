package sn.dev.suiviabsence.core.mapper;

import sn.dev.suiviabsence.core.domain.Absence;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class AbsenceDomainMapper {
  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

  public static Absence toDomain(sn.dev.suiviabsence.data.entities.Absence entity) {
    if (entity == null)
      return null;
    return new Absence(
        entity.getId(),
        "",
        entity.getDate() != null ? DATE_FORMAT.format(entity.getDate()) : null,
        entity.getJustification(),
        EtudiantDomainMapper.toDomain(entity.getEtudiant()),
        CoursDomainMapper.toDomain(entity.getCours()),
        entity.getStatus());
  }

  public static sn.dev.suiviabsence.data.entities.Absence toEntity(Absence domain) {
    if (domain == null)
      return null;
    sn.dev.suiviabsence.data.entities.Absence entity = new sn.dev.suiviabsence.data.entities.Absence();
    entity.setId(domain.getId());
    try {
      entity.setDate(domain.getDate() != null ? DATE_FORMAT.parse(domain.getDate()) : null);
    } catch (ParseException e) {
      entity.setDate(new Date());
    }
    entity.setJustification(domain.getJustification());
    entity.setStatus(domain.getStatus());
    entity.setEtudiant(EtudiantDomainMapper.toEntity(domain.getEtudiant()));
    entity.setCours(CoursDomainMapper.toEntity(domain.getCours()));
    return entity;
  }
}