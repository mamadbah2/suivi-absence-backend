package sn.dev.suiviabsence.core.service;

import sn.dev.suiviabsence.core.domain.User;

public interface UserService {
  User getCurrentUser();

  User authenticate(String email, String password);
}