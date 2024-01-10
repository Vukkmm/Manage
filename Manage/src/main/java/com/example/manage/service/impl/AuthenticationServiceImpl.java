package com.example.manage.service.impl;

import com.example.manage.dto.response.authen.LoginResponse;
import com.example.manage.service.AccountService;
import com.example.manage.service.AuthenticationService;
import com.example.manage.service.JwtTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AccountService accountService;
    private final JwtTokenService jwtTokenService;

    @Override
    public LoginResponse login(String username, String password) {
        log.info("(signIn)  username:   {}, password:    {}", username, password);
        var account = accountService.getDetailUserByUsername(username);
        accountService.equalPassword(password, account.getPassword());
        return null;
    }
}
