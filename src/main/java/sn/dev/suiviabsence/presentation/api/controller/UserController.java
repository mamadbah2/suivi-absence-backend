package sn.dev.suiviabsence.presentation.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.dev.suiviabsence.presentation.api.dto.response.UserResponseDto;

@RestController
@RequestMapping("/users")
public interface UserController {

  @GetMapping("/me")
  ResponseEntity<UserResponseDto> getCurrentUser();
}