package com.github.lume.api.api.validations.user;

import com.github.lume.api.api.dto.user.UserRequestDTO;
import com.github.lume.api.api.dto.user.login.LoginRequestDTO;

public interface UserValidator {
    void validateUserCreation(UserRequestDTO request);
    void validateLogin(LoginRequestDTO request);
}
