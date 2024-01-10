package com.example.manage.service.impl;

import com.example.manage.exception.NotFoundException;
import com.example.manage.service.JwtTokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.example.manage.constant.constants.Message.ID_EXIST;

@Service
@Slf4j
public class JwtTokenServiceImpl implements JwtTokenService {
    @Value("${token.key}")
    private String tokenKey;

    @Value("${token.expire-time-access-token}")
    private long expireTimeAccessToken;

    @Value("${token.expire-time-refresh-token}")
    private long expireTimeRefreshToken;

    @Override
    public String generateAccessToken(String accountId, Map<String, Object> claims) {
        log.info("(generateAccessToken)start");
        return generateToken(accountId, claims,expireTimeRefreshToken);
    }

    @Override
    public String generateRefreshToken(String accountId, String username) {
        log.info("(generateRefreshToken)start");
        //HashMap<String, Object> claims = new HashMap<String, Object>();
        var claims = new HashMap<String, Object>();
        claims.put("username", username);
        return generateToken(accountId, claims,expireTimeAccessToken);
    }

    @Override
    public String getSubjectFromToken(String token) {
        log.info("(getSubjectFromToken)");
        validateToken(token);
        return getClaims(token, tokenKey).getSubject();
    }

    @Override
    public String getUsernameFromToken(String token) {
        validateToken(token);
        log.info("(getUsernameFromToken) start");
        Map<String, Object> claims = (Map<String, Object>) getClaims(token, tokenKey).get("claims");
        return String.valueOf(claims.get("username"));
    }

    public void validateToken(String token) {
        log.info("(validateToken)start");
        if (!isValidToken(token)) {
            log.error("(validateToken) ==========> TokenInvalidException");
            throw new NotFoundException(ID_EXIST) ;
        }
        if (isExpiredToken(token)) {
            log.error("(validateToken) ==========> TokenExpiredException");
            throw new NotFoundException(ID_EXIST);
        }
    }
    /**
     * Kiểm tra tính hợp lệ của Token
     */
    public Boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(tokenKey).parseClaimsJws(token);
            return (Boolean) true;
        } catch (JwtException | IllegalArgumentException e) {
            return (Boolean) false;
        }
    }

    /**
     * Lấy thông tin ở trong token
     */
    private Claims getClaims(String token, String secretKey) {
        log.info("(getClaims)");
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    /**
     * Kiểm tra xem token đã hết hạn hay chưa
     */
    public Boolean isExpiredToken(String token) {
        return (Boolean) getClaims(token, tokenKey).getExpiration().before(new Date());
    }

    private String generateToken(String accountId, Map<String, Object> claims, long tokenLifeTime) {
        log.info("(generate)start");
        return Jwts.builder()
                .setSubject(accountId)
                .claim("claims", claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tokenLifeTime))
                .signWith(SignatureAlgorithm.HS256, tokenKey)
                .compact();

    }
}
