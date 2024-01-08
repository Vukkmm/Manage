package com.example.manage.service.impl;

import com.example.manage.dto.response.authen.LoginResponse;
import com.example.manage.service.AccountService;
import com.example.manage.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AccountService accountService;

    @Override
    public LoginResponse login(String username, String password) {
        return null;
    }
}
