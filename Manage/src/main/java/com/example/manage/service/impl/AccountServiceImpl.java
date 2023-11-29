package com.example.manage.service.impl;

import com.example.manage.dto.response.AccountResponse;
import com.example.manage.entity.Account;
import com.example.manage.repository.AccountRepository;
import com.example.manage.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public Account create(String username, String password) {
        log.info("(create) :username: {}, password: {}", username, password);

        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return accountRepository.save(account);
    }

    @Override
    public Account update(Long id, String username, String password) {
        log.info("(update) id: {}, :username: {}, password: {}", id, username, password);
        Account account = new Account();
        account.setId(id);
        account.setUsername(username);
        account.setPassword(password);

        return accountRepository.save(account);
    }

}
