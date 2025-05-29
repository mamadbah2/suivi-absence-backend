package sn.dev.suiviabsence.mobile.controllers.impl;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import sn.dev.suiviabsence.data.entities.User;
import sn.dev.suiviabsence.mobile.controllers.AuthController;
import sn.dev.suiviabsence.mobile.dto.requests.UserLoginRequest;
import sn.dev.suiviabsence.mobile.dto.response.UserLoginResponse;
import sn.dev.suiviabsence.security.JwtUtils;
import sn.dev.suiviabsence.services.UserService;

@RestController
public class AuthControllerImpl implements AuthController {

    private final UserService userService;
    private final JwtUtils jwtUtils;

    public AuthControllerImpl(UserService userService, JwtUtils jwtUtils) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public ResponseEntity<UserLoginResponse> login(UserLoginRequest request) {
        System.out.println("\n*****************START login");
        User checkUser = userService.getByEmail(request.getEmail());

        if (checkUser == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect email");
        }

        System.out.println("request: " + request);
        System.out.println("user password: '" + checkUser.getPassword() + "'");
        System.out.println("dto password: '" + request.getPassword() + "'");

        if (request.getPassword().equals(checkUser.getPassword())) {
            String token = jwtUtils.generateToken(checkUser);

            UserLoginResponse response = new UserLoginResponse(
                    token
            );

            return ResponseEntity.ok()
                    .header(HttpHeaders.CACHE_CONTROL, "no-store")
                    .body(response);
        } else {
            System.out.println("FAILED !!!");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect password");
        }
    }
}
