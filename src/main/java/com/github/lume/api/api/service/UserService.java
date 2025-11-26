package com.github.lume.api.api.service;

import com.github.lume.api.api.dto.user.login.LoginRequestDTO;
import com.github.lume.api.api.dto.user.login.LoginResponseDTO;
import com.github.lume.api.api.exception.user.InvalidUserDataException;
import com.github.lume.api.api.exception.user.UserNotFoundException;
import com.github.lume.api.api.model.User;
import com.github.lume.api.api.repository.UserRepository;
import com.github.lume.api.api.validations.user.DefaultUserValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final DefaultUserValidator defaultUserValidator;

    public UserService(UserRepository userRepository, DefaultUserValidator defaultUserValidator) {
        this.userRepository = userRepository;
        this.defaultUserValidator = defaultUserValidator;
    }

    public LoginResponseDTO login(LoginRequestDTO request) {
        defaultUserValidator.validateLogin(request);


        User user = userRepository.findByEmail(request.email()).orElseThrow(() -> new InvalidUserDataException("Usuário ou senha inválidos."));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


        return null;

    }
}
