package com.github.lume.api.api.dto.user;

import com.github.lume.api.api.model.Role;
import com.github.lume.api.api.model.User;

public record UserResponseDTO (int id, Role role) {
    public static UserResponseDTO fromEntity(User user) {
        return new UserResponseDTO(user.getId(), user.getRole());
    }
}
