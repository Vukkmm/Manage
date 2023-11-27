package com.example.manage.controller;

import com.example.manage.dto.common.ResponseGeneral;
import com.example.manage.dto.request.UserRequest;
import com.example.manage.dto.response.UserResponse;
import com.example.manage.entity.User;
import com.example.manage.facade.UserFacadeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserFacadeService userFacadeService;

    @PostMapping
    public ResponseGeneral<UserResponse> create(@RequestBody UserRequest request) {
        log.info("(request) create:{}",request );
        return ResponseGeneral.ofCreated(userFacadeService.create(request));
    }
}
