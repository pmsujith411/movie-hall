package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieHallController {

    @GetMapping("/")
    String home() {
        return "Spring is here!";
    }

    @PutMapping("/user/{emailId}/{roleId}")
    public String updateRole(@PathVariable("emailId") String userId, @PathVariable("roleId") String roleId) {
        return "ok";
    }
}
