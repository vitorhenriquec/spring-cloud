package com.demo.server.controller;

import com.demo.server.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @GetMapping("/")
    public Account getEvent() {
        var account = new Account(1L, "me");
        return account;
    }

}
