package sn.dev.suiviabsence.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sn.dev.suiviabsence.data.entities.Etudiant;
import sn.dev.suiviabsence.data.entities.User;
import sn.dev.suiviabsence.data.repositories.EtudiantRepository;
import sn.dev.suiviabsence.data.repositories.UserRepository;
import sn.dev.suiviabsence.services.UserService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EtudiantRepository etudiantRepository;

    public User getByEmail(String email) {
        // Chercher d'abord dans UserRepository (vigiles)
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        }

        // Puis chercher dans EtudiantRepository (étudiants)
        Optional<Etudiant> etudiant = etudiantRepository.findByEmail(email);
        if (etudiant.isPresent()) {
            return etudiant.get(); // Etudiant extends User
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user with this email");
    }
}
