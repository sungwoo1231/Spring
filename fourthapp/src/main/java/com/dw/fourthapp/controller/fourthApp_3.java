package com.dw.fourthapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class fourthApp_3 {
    @GetMapping("/1")
    public String hi(){
        return "hi";
    }
}
