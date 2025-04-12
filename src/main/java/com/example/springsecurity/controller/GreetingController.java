package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greeting")
public class GreetingController {

    @GetMapping("/sayHelloPublic")
    public String hello() {
        return "Hello Api";
    }

    @GetMapping("/sayHelloProtected")
    public String sayHelloProtected() {
        return "Hello Api Protected";
    }

}
