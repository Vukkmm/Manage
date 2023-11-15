package com.example.Manage.controller;

import com.example.Manage.dto.request.FullNameRequest;
import com.example.Manage.dto.request.UserRequest;
import com.example.Manage.entity.FullName;
import com.example.Manage.entity.User;
import com.example.Manage.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserRequest userRequest) {
        User user = userService.create(userRequest);
        return ResponseEntity.ok().body(user);
    }
}
