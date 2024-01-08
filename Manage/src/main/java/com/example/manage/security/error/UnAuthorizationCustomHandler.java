package com.example.manage.security.error;

import com.example.manage.utils.DateUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.util.HashMap;

public class UnAuthorizationCustomHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        var error = new HashMap<String, Object>();
        error.put("status", 403);
        error.put("timestamp", DateUtils.getCurrentDateString());
        error.put("message", "UnAuthorization");
        response.sendError(401, new ObjectMapper().writeValueAsString(error));
    }
}
