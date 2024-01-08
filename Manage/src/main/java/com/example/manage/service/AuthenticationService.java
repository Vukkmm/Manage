package com.example.manage.service;

import com.example.manage.dto.response.authen.LoginResponse;

public interface AuthenticationService {
    LoginResponse login(String username, String password);
}
