package sn.dev.suiviabsence.presentation.api.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sn.dev.suiviabsence.core.domain.User;
import sn.dev.suiviabsence.core.mapper.UserMapper;
import sn.dev.suiviabsence.core.service.UserService;
import sn.dev.suiviabsence.presentation.api.controller.UserController;
import sn.dev.suiviabsence.presentation.api.dto.request.UserLoginDto;
import sn.dev.suiviabsence.presentation.api.dto.response.UserResponseDto;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

  private final UserService userService;

  @Override
  public ResponseEntity<Map<String, Object>> authenticate(UserLoginDto userLoginDto) {
    log.info("Tentative d'authentification pour l'utilisateur: {}", userLoginDto.getEmail());

    User authenticatedUser = userService.authenticate(userLoginDto.getEmail(), userLoginDto.getPassword());
    UserResponseDto userDto = UserMapper.toDto(authenticatedUser);

    Map<String, Object> response = new HashMap<>();
    response.put("success", true);
    response.put("message", "Authentification réussie");
    response.put("user", userDto);

    return ResponseEntity.ok(response);
  }
}