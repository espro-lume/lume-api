package com.github.lume.api.api.service;

import com.github.lume.api.api.dto.user.UserRequestDTO;
import com.github.lume.api.api.dto.user.UserResponseDTO;
import com.github.lume.api.api.model.Role;
import com.github.lume.api.api.model.User;
import com.github.lume.api.api.repository.UserRepository;
import com.github.lume.api.api.validations.user.DefaultUserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final DefaultUserValidator defaultUserValidator;

    public UserResponseDTO createAdmin(UserRequestDTO request) {
        defaultUserValidator.validateUserCreation(request);

        // nome e email
        User user = new User(request);

        String encodedPassword = new BCryptPasswordEncoder().encode(request.password());
        user.setPassword(encodedPassword);

        user.setRole(Role.ADMIN);

        return UserResponseDTO.fromEntity(userRepository.save(user));
    }
}
