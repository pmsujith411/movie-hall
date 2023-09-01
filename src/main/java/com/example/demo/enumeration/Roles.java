package com.example.demo.enumeration;

public enum Roles {

    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String value;

    Roles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
