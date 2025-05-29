package sn.dev.suiviabsence.core.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import sn.dev.suiviabsence.core.domain.User;
import sn.dev.suiviabsence.presentation.api.dto.response.UserResponseDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {
    
    public static UserResponseDto toDto(User user) {
        if (user == null) {
            return null;
        }
        
        return UserResponseDto.builder()
                .id(user.getId())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
} 