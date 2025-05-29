package sn.dev.suiviabsence.presentation.api.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import sn.dev.suiviabsence.core.service.UserService;
import sn.dev.suiviabsence.core.mapper.UserMapper;
import sn.dev.suiviabsence.presentation.api.controller.UserController;
import sn.dev.suiviabsence.presentation.api.dto.response.UserResponseDto;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

  private final UserService userService;

  @Override
  public ResponseEntity<UserResponseDto> getCurrentUser() {
    return ResponseEntity.ok(UserMapper.toDto(userService.getCurrentUser()));
  }
}