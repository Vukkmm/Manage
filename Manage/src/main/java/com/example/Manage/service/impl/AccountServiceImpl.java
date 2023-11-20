package com.example.Manage.service.impl;

import com.example.Manage.dto.request.AccountRequest;
import com.example.Manage.dto.response.AccountResponse;
import com.example.Manage.entity.Account;
import com.example.Manage.entity.User;
import com.example.Manage.repository.AccountRepository;
import com.example.Manage.repository.UserRepository;
import com.example.Manage.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public AccountResponse create(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        accountRepository.save(account);
        return AccountResponse.of(account.getId(), username, password);
    }

}
