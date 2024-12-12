package com.dw.secondapp.controller;

import com.dw.secondapp.service.HelloService_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController_2 {
    @Autowired
    HelloService_2 helloService_2;
    @GetMapping("/login")
    public String login(){
        return helloService_2.hello();

    }
}
