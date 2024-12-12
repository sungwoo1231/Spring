package com.dw.firstapp.Controller;

import com.dw.firstapp.Service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping("/sayhello")
    public String hello() {
        return helloService.hello();
    }
}
