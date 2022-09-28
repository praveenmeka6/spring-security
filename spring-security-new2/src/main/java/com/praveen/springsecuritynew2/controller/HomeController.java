package com.praveen.springsecuritynew2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {


    @GetMapping("/user")
    public String user() {
        return "At user";
    }
}
