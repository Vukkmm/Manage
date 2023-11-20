package com.example.Manage.facade;

import com.example.Manage.dto.request.UserRequest;
import com.example.Manage.dto.response.UserResponse;

public interface UserFacadeService {
    UserResponse create(UserRequest userRequest);
}
