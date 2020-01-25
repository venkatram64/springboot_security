package com.venkat.jdbcsecurityjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyHomeController {

    @GetMapping("/")
    public String home(){
        return "Welcome";
    }

    @GetMapping("/user")
    public String user(){
        return "Welcom user";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Welcome admin";
    }
}
