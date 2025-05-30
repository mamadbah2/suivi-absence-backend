package sn.dev.suiviabsence.mobile.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.dev.suiviabsence.mobile.dto.requests.UserLoginRequest;
import sn.dev.suiviabsence.mobile.dto.response.UserLoginResponse;

@RequestMapping("app/auth")
public interface AuthController {

    @PostMapping("/login")
    ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request);

}
