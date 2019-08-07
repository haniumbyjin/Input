package com.input.demo.controller;

import com.input.demo.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "authorization")
public class SignInController {
    @GetMapping("/signin")
    public User get() {
        return new User(0, "Hello Spring Boot!");
    }
}