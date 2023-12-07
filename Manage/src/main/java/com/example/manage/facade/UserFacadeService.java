package com.example.manage.facade;

import com.example.manage.dto.request.UserRequest;
import com.example.manage.dto.response.UserResponse;

public interface UserFacadeService {
    UserResponse create(UserRequest request);

    UserResponse update(Long id, UserRequest request);

    void delete(Long id);
}
