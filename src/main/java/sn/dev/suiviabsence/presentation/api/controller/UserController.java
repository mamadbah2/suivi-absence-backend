package sn.dev.suiviabsence.presentation.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.dev.suiviabsence.presentation.api.dto.request.UserLoginDto;
import java.util.Map;

@RequestMapping("/api/users")
public interface UserController {
    
    @PostMapping("/auth")
    ResponseEntity<Map<String, Object>> authenticate(@RequestBody UserLoginDto userLoginDto);
}