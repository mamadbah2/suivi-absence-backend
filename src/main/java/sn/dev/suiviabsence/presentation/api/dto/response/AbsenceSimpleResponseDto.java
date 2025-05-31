package sn.dev.suiviabsence.presentation.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceSimpleResponseDto {
  private String matricule;
  private String nom;
  private String prenom;
  private String classe;
  private String module;
  private String date;
  private String heure;
  private String justification;
  private String status;
}