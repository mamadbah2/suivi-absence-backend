package sn.dev.suiviabsence.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.dev.suiviabsence.core.domain.enums.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
  private String id;
  private String nom;
  private String prenom;
  private String email;
  private Role role;
}