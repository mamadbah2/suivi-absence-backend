package sn.dev.suiviabsence.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sn.dev.suiviabsence.data.entities.User;
import sn.dev.suiviabsence.services.UserService;
import sn.dev.suiviabsence.utils.mappers.UserMapper;
import sn.dev.suiviabsence.web.dto.response.UserResponseDto;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserMapper userMapper;

  @Override
  public UserResponseDto getCurrentUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null || !authentication.isAuthenticated()) {
      return null;
    }

    Object principal = authentication.getPrincipal();
    if (principal instanceof User) {
      return userMapper.toDto((User) principal);
    }

    return null;
  }
}