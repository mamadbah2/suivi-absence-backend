package sn.dev.suiviabsence.core.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.dev.suiviabsence.core.domain.User;
import sn.dev.suiviabsence.core.service.UserService;
import sn.dev.suiviabsence.infrastructure.persistence.UserRepository;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User authenticate(String email, String password) {
    return userRepository.findByEmail(email)
        .filter(user -> passwordEncoder.matches(password, user.getPassword()))
        .orElseThrow(() -> new RuntimeException("Invalid credentials"));
  }

  @Override
  public User createUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  @Override
  public User getCurrentUser() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String email;
    if (principal instanceof UserDetails) {
      email = ((UserDetails) principal).getUsername();
    } else {
      email = principal.toString();
    }
    return userRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'email : " + email));
  }
}