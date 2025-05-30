package sn.dev.suiviabsence.web.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.dev.suiviabsence.services.UserService;
import sn.dev.suiviabsence.web.controllers.UserController;
import sn.dev.suiviabsence.web.dto.response.UserResponseDto;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

  private final UserService userService;

  @Override
  @GetMapping
  public ResponseEntity<UserResponseDto> getCurrentUser() {
    UserResponseDto currentUser = userService.getCurrentUser();
    if (currentUser == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(currentUser);
  }
}