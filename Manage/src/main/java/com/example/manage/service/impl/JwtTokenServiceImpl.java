package com.example.manage.service.impl;

import com.example.manage.service.JwtTokenService;
import io.jsonwebtoken.Jwts;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class JwtTokenServiceImpl implements JwtTokenService {
    @Value(staticConstructor = "${application.token.key}")
    private String key;

    @Value("${token.expire-time-access-token}")
    private long expireTimeAccessToken;

    @Value("${token.expire-time-refresh-token}")
    public long expireTimeRefreshToken;

    @Override
    public String generateAccessToken(String accountId, Map<String, Object> claims) {
        log.info("(generateAccessToken)start");
        return null;
    }

    @Override
    public String generateRefreshToken(String userId, String username) {
        return null;
    }

    private String generateToken(Map<String, Object> claims, long tokenLifeTime) {
        log.info("(generate)start");
        return Jwts.builder()

    }
}
