package com.example.manage.service.impl;

import com.example.manage.entity.Account;
import com.example.manage.exception.AccountExistsException;
import com.example.manage.exception.NotFoundException;
import com.example.manage.repository.AccountRepository;
import com.example.manage.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.example.manage.constant.constants.Message.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Account create(String username, String password) {
        log.info("(create) :username: {}, password: {}", username, password);
        String encodePassword = passwordEncoder.encode(password);
        if (isUsernameExists(username)) {
            throw new AccountExistsException(USERNAME_EXIST);
        }
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(encodePassword);
        account.setDelete(false);
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public Account update(Long id, String password) {
        log.info("(update) id: {},  password: {}", id, password);
        Account account = accountRepository.findById(id).orElse(null);
        if (Objects.nonNull(account)) {
            setValueUpdate(account, password);
            accountRepository.save(account);
        } else {
            throw new NotFoundException(ID_EXIST);
        }
        return account;
    }


    @Override
    @Transactional
    public void delete(Long id) {
        log.info("(delete) id:{}", id);
        Account account = accountRepository.findById(id).orElse(null);
        if (Objects.nonNull(account)) {
            accountRepository.delete(account);
        } else {
            throw new NotFoundException(ID_EXIST);
        }
    }

    @Override
    public boolean isUsernameExists(String username) {
        return accountRepository.existsByUsername(username);
    }

    private void setValueUpdate(Account account, String password) {
        account.setPassword(passwordEncoder.encode(password));
    }
}
