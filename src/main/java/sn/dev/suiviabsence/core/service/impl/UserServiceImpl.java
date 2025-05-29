package sn.dev.suiviabsence.core.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sn.dev.suiviabsence.core.domain.User;
import sn.dev.suiviabsence.infrastructure.persistence.UserRepository;
import sn.dev.suiviabsence.core.service.UserService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public User getCurrentUser() {
    var authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication == null) {
      log.warn("Tentative d'accès sans authentification");
      return null;
    }

    if (!authentication.isAuthenticated()) {
      log.warn("Utilisateur non authentifié");
      return null;
    }

    Object principal = authentication.getPrincipal();
    if (principal instanceof UserDetails) {
      String email = ((UserDetails) principal).getUsername();
      log.info("Récupération de l'utilisateur avec l'email: {}", email);

      return userRepository.findByEmail(email)
          .orElseGet(() -> {
            log.error("Utilisateur {} non trouvé dans la base", email);
            return null;
          });
    }

    log.warn("Principal n'est pas une instance de UserDetails");
    return null;
  }

  @Override
  public User authenticate(String email, String password) {
    log.info("Tentative d'authentification pour l'email: {}", email);

    return userRepository.findByEmail(email)
        .filter(user -> passwordEncoder.matches(password, user.getPassword()))
        .orElseThrow(() -> {
          log.error("Échec d'authentification pour l'email: {}", email);
          return new BadCredentialsException("Email ou mot de passe incorrect");
        });
  }
}