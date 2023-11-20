package com.example.Manage.controller;

import com.example.Manage.dto.common.ResponseGeneral;
import com.example.Manage.dto.request.UserRequest;
import com.example.Manage.dto.response.UserResponse;
import com.example.Manage.entity.User;
import com.example.Manage.facade.UserFacadeService;
import com.example.Manage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserFacadeController {
    private final UserFacadeService userFacadeService;

    @PostMapping
    public ResponseGeneral<UserResponse> create(@RequestBody UserRequest userRequest) {
        return ResponseGeneral.ofCreated(userFacadeService.create(userRequest));
    }
}
