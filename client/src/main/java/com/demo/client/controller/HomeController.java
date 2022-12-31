package com.demo.client.controller;

import com.demo.client.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public void account() {
        var account = this.restTemplate.exchange("http://server/", HttpMethod.GET, null, Account.class);

        System.out.println(account.getBody().getId());
        System.out.println(account.getBody().getOwner());
    }

}
