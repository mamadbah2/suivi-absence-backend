package sn.dev.suiviabsence.presentation.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceMobileSimpleResponse {
  private String module;
  private String heureDebut;
  private String heureFin;
  private String justification;
  private String status;
}