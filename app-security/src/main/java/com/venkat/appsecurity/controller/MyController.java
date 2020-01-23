package com.venkat.appsecurity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//https://www.youtube.com/watch?v=I0poT4UxFxE&list=PLqq-6Pq4lTTYTEooakHchTGglSvkZAjnE&index=2

@RestController
public class MyController {

    @GetMapping("/")
    public String greetings(){
        return "Hello, World.";
    }

    @GetMapping("/user")
    public String user(){
        return "Hello, User.";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Hello, Admin.";
    }
}
