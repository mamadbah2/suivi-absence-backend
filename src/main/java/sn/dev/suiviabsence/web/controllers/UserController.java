package sn.dev.suiviabsence.web.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.dev.suiviabsence.data.entities.User;
import sn.dev.suiviabsence.web.dto.requests.UserLoginDto;
import sn.dev.suiviabsence.web.dto.response.AbsenceSimpleResponseDto;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public interface UserController {
    @PostMapping("/auth")
    ResponseEntity<Map<String, Object>> authentification(@RequestBody UserLoginDto userLoginDto) ;

}
