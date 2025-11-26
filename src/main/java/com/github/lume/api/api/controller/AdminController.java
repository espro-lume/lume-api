package com.github.lume.api.api.controller;

import com.github.lume.api.api.dto.user.UserRequestDTO;
import com.github.lume.api.api.dto.user.UserResponseDTO;
import com.github.lume.api.api.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO request) {
        return ResponseEntity.ok(adminService.createAdmin(request));
    }

//    public ResponseEntity<?> addCourse() {
//
//    }

}
