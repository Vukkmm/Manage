package com.example.Manage.controller;

import com.example.Manage.dto.request.AccountRequest;
import com.example.Manage.entity.Account;
import com.example.Manage.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

//    @PostMapping
//    public ResponseEntity<Account> create(@RequestBody AccountRequest accountRequest) {
//        Account account = accountService.create(accountRequest);
//        return ResponseEntity.ok().body(account);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> update(@RequestBody AccountRequest accountRequest,@PathVariable Long id) {
        Account account = accountService.update(id, accountRequest);
        return ResponseEntity.ok().body(account);
    }


}
