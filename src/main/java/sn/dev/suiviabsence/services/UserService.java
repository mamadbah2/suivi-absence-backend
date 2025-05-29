package sn.dev.suiviabsence.services;

import sn.dev.suiviabsence.data.entities.User;

public interface UserService {
    User getByEmail(String email);
}
