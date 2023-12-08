package com.example.manage.service;

import com.example.manage.dto.response.UserResponse;
import com.example.manage.entity.Account;
import com.example.manage.entity.Address;
import com.example.manage.entity.FullName;
import com.example.manage.entity.User;

import java.util.List;

public interface UserService {
    User create(String age, String sex, Account account, FullName fullName, Address address);

    UserResponse detail(Long id);

    User update(Long id, String age, String sex, Account account, FullName fullName, Address address);

    void delete(Long id);

    List<UserResponse> list();

}
