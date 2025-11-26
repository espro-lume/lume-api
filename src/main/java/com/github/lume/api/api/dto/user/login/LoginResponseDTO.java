package com.github.lume.api.api.dto.user.login;

import com.github.lume.api.api.model.Role;
import com.github.lume.api.api.model.User;

public record LoginResponseDTO(int id, Role role) {
    public static LoginResponseDTO fromEntity(User user) {
        return new LoginResponseDTO(user.getId(), user.getRole());
    }
}
