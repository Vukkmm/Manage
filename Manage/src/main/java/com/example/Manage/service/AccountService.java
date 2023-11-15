package com.example.Manage.service;

import com.example.Manage.dto.request.AccountRequest;
import com.example.Manage.entity.Account;
import com.example.Manage.entity.User;

public interface AccountService {
    //Account create(AccountRequest accountRequest);

    Account update(Long id, AccountRequest accountRequest);
}
