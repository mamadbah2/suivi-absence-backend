package sn.dev.suiviabsence.mobile.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.dev.suiviabsence.data.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponse {
    private String token;
}
