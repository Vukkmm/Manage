package com.example.Manage.service;

import com.example.Manage.dto.request.AccountRequest;
import com.example.Manage.dto.response.AccountResponse;
import com.example.Manage.entity.Account;
import com.example.Manage.entity.User;

public interface AccountService {
    AccountResponse create(AccountRequest accountRequest);

    //Account update(Long id, AccountRequest accountRequest);
}
