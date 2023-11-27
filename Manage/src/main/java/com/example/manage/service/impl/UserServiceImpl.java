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
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public User create(String age, String sex, Account account, FullName fullName, Address address) {
        log.info("(request) create:age: {}, sex: {}, account: {}, fullName: {}, address: {}", age, sex, account, fullName, address);
        User user = new User();
        user.setAge(age);
        user.setSex(sex);
        user.setAccount(account);
        user.setAddress(address);
        user.setFullName(fullName);

        return userRepository.save(user);
    }


}
