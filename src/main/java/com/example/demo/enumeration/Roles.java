package com.example.demo.enumeration;

public enum Roles {

    ADMIN("admin"),
    USER("user");

    private String value;

    Roles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
