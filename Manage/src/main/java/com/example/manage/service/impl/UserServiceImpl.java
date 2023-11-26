package com.example.manage.service.impl;

import com.example.manage.dto.request.UserRequest;
import com.example.manage.dto.response.UserResponse;
import com.example.manage.entity.Account;
import com.example.manage.entity.Address;
import com.example.manage.entity.FullName;
import com.example.manage.entity.User;
import com.example.manage.repository.AccountRepository;
import com.example.manage.repository.UserRepository;
import com.example.manage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Override
    public User create(String age, String sex, Account account, FullName fullName, Address address) {
        User user = new User();
        user.setAge(age);
        user.setSex(sex);
        user.setAccount(account);
        user.setAddress(address);
        user.setFullName(fullName);

        return userRepository.save(user);
    }


}
