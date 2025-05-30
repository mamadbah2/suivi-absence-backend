package sn.dev.suiviabsence.utils.mappers;

import org.springframework.stereotype.Component;
import sn.dev.suiviabsence.data.entities.User;
import sn.dev.suiviabsence.web.dto.response.UserResponseDto;

@Component
public class UserMapper {

  public UserResponseDto toDto(User user) {
    if (user == null) {
      return null;
    }

    return UserResponseDto.builder()
        .id(user.getId())
        .username(user.getUsername())
        .email(user.getEmail())
        .role(user.getRole())
        .build();
  }
}