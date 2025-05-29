package sn.dev.suiviabsence.mobile.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {
    @NotNull
    private String email;

    @NotNull
    private String password;
}
