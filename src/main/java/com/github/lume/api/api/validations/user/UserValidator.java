package com.github.lume.api.api.validations.user;

import com.github.lume.api.api.dto.user.UserRequestDTO;

public interface UserValidator {
    void validateUserCreation(UserRequestDTO request);
}
