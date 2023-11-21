package com.example.Manage.service;

import com.example.Manage.entity.User;

public interface UserService {
    User create(Long id, String age, String sex);

    void save(User user);

}
