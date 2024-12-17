package com.example.ejemploauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@PreAuthorize(("denyAll"))
public class GreetingsController {

    @GetMapping("/sayhi")
    @PreAuthorize(("permiteAll"))
    public String sayHi(){
        return "Hi! This is a not secured endpoint";
    }

    @GetMapping("/sayhisec")
    @PreAuthorize("isAuthenticated()")
    public String sayHiSec(){
        return "Hi This is a secured endpoint";
    }

}
