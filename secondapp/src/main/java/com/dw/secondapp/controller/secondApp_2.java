package com.dw.secondapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class secondApp_2 {
    @GetMapping("/login")
    public String login(){
        return "login : " + "입력하시오";

    }
}
