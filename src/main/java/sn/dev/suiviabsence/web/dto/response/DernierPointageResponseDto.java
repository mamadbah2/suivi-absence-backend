package sn.dev.suiviabsence.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DernierPointageResponseDto {
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