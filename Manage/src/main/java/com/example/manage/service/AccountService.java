package com.example.manage.service;

import com.example.manage.entity.Account;

public interface AccountService {
    Account create(String username, String password);

    Account update(Long id, String password);

    void delete(Long id);

    boolean isUsernameOrPasswordExists(String username, String password);

}
