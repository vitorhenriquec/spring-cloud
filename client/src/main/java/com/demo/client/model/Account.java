package com.demo.client.model;

public class Account {
    private Long id;

    private String owner;

    public Account() {

    }

    public Account(Long id, String owner) {
        this.id = id;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
