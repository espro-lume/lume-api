package com.github.lume.api.api.service;

import com.github.lume.api.api.dto.user.UserRequestDTO;
import com.github.lume.api.api.dto.user.UserResponseDTO;
import com.github.lume.api.api.model.Role;
import com.github.lume.api.api.model.User;
import com.github.lume.api.api.repository.UserRepository;
import com.github.lume.api.api.validations.user.DefaultUserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientService {

    private final UserRepository userRepository;
    private final DefaultUserValidator defaultUserValidator;

    public UserResponseDTO createClient(UserRequestDTO request) {
        defaultUserValidator.validateUserCreation(request);

        // nome e email
        User user = new User(request);

        String encodedPassword = new BCryptPasswordEncoder().encode(request.password());
        user.setPassword(encodedPassword);

        user.setRole(Role.CLIENT);

        return UserResponseDTO.fromEntity(userRepository.save(user));
    }
}
