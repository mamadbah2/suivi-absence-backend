package sn.dev.suiviabsence.core.services;

import sn.dev.suiviabsence.core.domain.User;
import java.util.Optional;
 
public interface UserService {
    Optional<User> authenticate(String email, String password);
    User createUser(User user);
} 