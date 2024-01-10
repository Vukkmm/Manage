package com.example.manage.service;

import java.util.Map;

public interface JwtTokenService {
    String generateAccessToken(String accountId, Map<String, Object> claims);
    String generateRefreshToken(String accountId, String username);

    String getSubjectFromToken(String token);

    String getUsernameFromToken(String token);

}
