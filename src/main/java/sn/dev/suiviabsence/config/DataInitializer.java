package sn.dev.suiviabsence.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import sn.dev.suiviabsence.core.domain.User;
import sn.dev.suiviabsence.core.domain.enums.Role;
import sn.dev.suiviabsence.infrastructure.persistence.UserRepository;

@Configuration
public class DataInitializer {

  @Bean
  public CommandLineRunner initData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    return args -> {
      // Créer un utilisateur de test s'il n'existe pas déjà
      if (!userRepository.findByEmail("admin@test.com").isPresent()) {
        User admin = new User();
        admin.setNom("Admin");
        admin.setPrenom("Test");
        admin.setEmail("admin@test.com");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setRole(Role.ADMIN);
        userRepository.save(admin);
      }
    };
  }
}