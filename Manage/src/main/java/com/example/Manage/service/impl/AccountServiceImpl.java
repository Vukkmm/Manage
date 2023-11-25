package com.example.Manage.service.impl;

import com.example.Manage.dto.request.AccountRequest;
import com.example.Manage.dto.response.AccountResponse;
import com.example.Manage.entity.Account;
import com.example.Manage.repository.AccountRepository;
import com.example.Manage.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public AccountResponse create(AccountRequest accountRequest) {
        Account account = new Account();
        account.setUsername(accountRequest.getUsername());
        account.setPassword(accountRequest.getPassword());
        accountRepository.save(account);
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(account.getId());
        accountResponse.setUsername(account.getUsername());
        accountResponse.setPassword(account.getPassword());
        return accountResponse;
    }

}
