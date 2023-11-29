package com.example.manage.service;

import com.example.manage.dto.request.AccountRequest;
import com.example.manage.dto.response.AccountResponse;
import com.example.manage.entity.Account;

public interface AccountService {
    Account create(String username, String password);

    Account update(Long id, String username, String password);

}
