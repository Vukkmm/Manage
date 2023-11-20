package com.example.Manage.service;

import com.example.Manage.dto.request.UserRequest;
import com.example.Manage.entity.User;

public interface UserService {
    User create(String age, String sex);

    void save(User user);

}
