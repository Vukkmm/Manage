package com.example.manage.controller;

import com.example.manage.dto.common.ResponseGeneral;
import com.example.manage.dto.request.authen.LoginRequest;
import com.example.manage.facade.UserFacadeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.manage.constant.constants.AuthConstant.LOGIN_SUCCESS;


@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final UserFacadeService userFacadeService;

    @PostMapping("login")
    public ResponseGeneral login(@RequestBody LoginRequest loginRequest) {
        log.info("(login)  request: {}", loginRequest);
        return ResponseGeneral.of(
                HttpStatus.OK.value(),
                LOGIN_SUCCESS,
                userFacadeService.login(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
    }


}
