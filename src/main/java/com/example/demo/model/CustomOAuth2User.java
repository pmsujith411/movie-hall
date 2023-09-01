package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class CustomOAuth2User {

    private String userName;

    private String emailId;

    private String role;

    private Map<String, Object> attributes;

    public CustomOAuth2User(Map<String, Object> attributes) {
        this.attributes = attributes;
        this.userName = (String)attributes.get("name");
        this.emailId = (String)attributes.get("email");
    }
}
