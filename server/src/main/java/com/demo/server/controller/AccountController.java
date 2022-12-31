package com.demo.server.controller;

import com.demo.server.model.Account;
import com.demo.server.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/")
    public Account getAccount() {
        var account = new Account(1L, "me");
        return account;
    }

    @PostMapping("/")
    public void saveAccount() {
        var account = new Account(1L, "me");

        this
    }

}
