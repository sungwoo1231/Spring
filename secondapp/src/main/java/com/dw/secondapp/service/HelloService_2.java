package com.dw.secondapp.service;

import com.dw.secondapp.respository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService_2 {
    @Autowired
    HelloRepository helloRepository;
    public String hello(){
        return helloRepository.hello();
    }
}
