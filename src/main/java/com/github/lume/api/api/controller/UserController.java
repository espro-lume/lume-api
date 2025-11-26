package com.github.lume.api.api.controller;

import com.github.lume.api.api.dto.user.login.LoginRequestDTO;
import com.github.lume.api.api.dto.user.login.LoginResponseDTO;
import com.github.lume.api.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
        LoginResponseDTO response =  userService.login(request);
        return ResponseEntity.ok(response);
    }

}
