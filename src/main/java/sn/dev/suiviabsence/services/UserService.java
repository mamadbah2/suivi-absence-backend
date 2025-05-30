package sn.dev.suiviabsence.services;

import sn.dev.suiviabsence.web.dto.response.UserResponseDto;

public interface UserService {
  UserResponseDto getCurrentUser();
}