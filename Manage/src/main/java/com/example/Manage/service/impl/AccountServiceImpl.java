package com.example.Manage.service.impl;

import com.example.Manage.dto.request.AccountRequest;
import com.example.Manage.entity.Account;
import com.example.Manage.entity.User;
import com.example.Manage.repository.AccountRepository;
import com.example.Manage.repository.UserRepository;
import com.example.Manage.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

//    @Override
//    public Account create(AccountRequest accountRequest) {
//        Account account = new Account();
//        account.setId(accountRequest.getId());
//        account.setUsername(accountRequest.getUsername());
//        account.setPassword(accountRequest.getPassword());
//        accountRepository.save(account);
//        return account;
//    }

    @Override
    public Account update(Long id, AccountRequest accountRequest) {
        User user = userRepository.findById(id).orElse(null);
        if(Objects.nonNull(user)) {
            Account account = new Account();
            account.setUsername(accountRequest.getUsername());
            account.setPassword(accountRequest.getPassword());
            accountRepository.save(account);
            return account;
        }
        return null;
    }
}
