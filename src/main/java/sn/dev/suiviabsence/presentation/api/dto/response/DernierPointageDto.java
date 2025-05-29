package sn.dev.suiviabsence.presentation.api.dto.response;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class DernierPointageDto {
  private String id;
  private String nom;
  private String prenom;
  private String classe;
  private String module;
  private Date date;
  private String heure;
  private String status;
  private String justification;
  private String justificatif;
}