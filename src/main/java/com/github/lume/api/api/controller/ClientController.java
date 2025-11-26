package com.github.lume.api.api.controller;

import com.github.lume.api.api.dto.user.UserRequestDTO;
import com.github.lume.api.api.dto.user.UserResponseDTO;
import com.github.lume.api.api.service.ClientService;
import com.github.lume.api.api.validations.user.DefaultUserValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    private final DefaultUserValidator defaultUserValidator;

    public ClientController(ClientService clientService, DefaultUserValidator defaultUserValidator) {
        this.clientService = clientService;
        this.defaultUserValidator = defaultUserValidator;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO request) {
        return ResponseEntity.ok(clientService.createClient(request));
    }
}
