package com.github.lume.api.api.controller;

import com.github.lume.api.api.dto.course.AddUserInCourseRequestDTO;
import com.github.lume.api.api.dto.user.UserRequestDTO;
import com.github.lume.api.api.dto.user.UserResponseDTO;
import com.github.lume.api.api.service.ClientService;
import com.github.lume.api.api.service.CourseService;
import com.github.lume.api.api.validations.user.DefaultUserValidator;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    private final DefaultUserValidator defaultUserValidator;
    private final CourseService courseService;

    public ClientController(ClientService clientService, DefaultUserValidator defaultUserValidator, CourseService courseService) {
        this.clientService = clientService;
        this.defaultUserValidator = defaultUserValidator;
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO request) {
        return ResponseEntity.ok(clientService.createClient(request));
    }

    @PostMapping("{id}")
    public ResponseEntity<HttpStatusCode> addUserInCourse(@PathVariable("id") String id, @RequestBody AddUserInCourseRequestDTO request) {
        courseService.addUserInCourse(id, request);
        return ResponseEntity.ok(HttpStatusCode.valueOf(200));
    }
}
