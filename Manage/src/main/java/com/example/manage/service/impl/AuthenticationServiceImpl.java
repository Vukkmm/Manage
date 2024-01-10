package com.example.manage.service.impl;

import com.example.manage.dto.response.authen.LoginResponse;
import com.example.manage.service.AccountService;
import com.example.manage.service.AuthenticationService;
import com.example.manage.service.JwtTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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

        var claims = new HashMap<String, Object>();
        claims.put("username", username);
        String accessToken = jwtTokenService.generateAccessToken(String.valueOf(account.getId()), claims);
        String refreshToken = jwtTokenService.generateRefreshToken(String.valueOf(account.getId()), account.getUsername());
        return new LoginResponse(accessToken, refreshToken);
    }
}
