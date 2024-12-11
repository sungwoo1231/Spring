package com.dw.thridapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class thirdApp_3 {
    @GetMapping("/password")
    public String password(){
        return "Id :  <br>password :  <br> join us";
    }
}
