package com.example.manage.service.impl;

import com.example.manage.dto.request.UserRequest;
import com.example.manage.dto.response.UserResponse;
import com.example.manage.entity.Account;
import com.example.manage.entity.Address;
import com.example.manage.entity.FullName;
import com.example.manage.entity.User;
import com.example.manage.exception.NotFoundException;
import com.example.manage.repository.AccountRepository;
import com.example.manage.repository.UserRepository;
import com.example.manage.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
@Slf4j
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public User create(String age, String sex, Account account, FullName fullName, Address address) {
        log.info("(create) request:age: {}, sex: {}, account: {}, fullName: {}, address: {}", age, sex, account, fullName, address);
        User user = new User();
        user.setAge(age);
        user.setSex(sex);
        user.setAccount(account);
        user.setAddress(address);
        user.setFullName(fullName);

        return userRepository.save(user);
    }

    @Override
    public UserResponse detail(Long id) {
        log.info("(detail) id: {}", id);
        UserResponse userResponse = userRepository.detail(id);
        if(userResponse == null) {
            throw new NotFoundException("id not found");
        }
        return userResponse;
    }


    @Override
    public User update(Long id, String age, String sex, Account account, FullName fullName, Address address) {
        log.info("(create) :id: {}, age: {}, sex: {}, account: {}, fullName: {}, address: {}", id, age, sex, account, fullName, address);
        User user = new User();
        user.setId(id);
        user.setAge(age);
        user.setSex(sex);
        user.setAccount(account);
        user.setAddress(address);
        user.setFullName(fullName);
        userRepository.save(user);

        return userRepository.save(user);

    }


}
