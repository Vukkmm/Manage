package com.example.Manage.service;

import com.example.Manage.dto.request.UserRequest;
import com.example.Manage.dto.response.UserResponse;
import com.example.Manage.entity.User;

public interface UserService {
    UserResponse create(UserRequest userRequest);

    void save(User user);

}
