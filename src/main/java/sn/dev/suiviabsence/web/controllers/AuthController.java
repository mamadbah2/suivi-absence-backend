package sn.dev.suiviabsence.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.dev.suiviabsence.core.domain.User;
import sn.dev.suiviabsence.core.services.UserService;

@RestController
@RequestMapping("/api/users")
public class AuthController {

  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/login")
  public ResponseEntity<Object> login(@RequestBody User loginRequest) {
    return userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword())
        .<ResponseEntity<Object>>map(user -> ResponseEntity.ok().body(user))
        .orElse(ResponseEntity.badRequest().body("Invalid credentials"));
  }

  @PostMapping("/register")
  public ResponseEntity<User> register(@RequestBody User user) {
    return ResponseEntity.ok(userService.createUser(user));
  }

  @GetMapping("/login")
  public ResponseEntity<String> loginPage() {
    return ResponseEntity.ok("Please login");
  }
}