package com.dw.jdbcapp.service;

import com.dw.jdbcapp.model.Customer;
import com.dw.jdbcapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository custmoerRepostitory;

    public List<Customer> getAllCustomers(){
        return custmoerRepostitory.getAllCustomers();
    }
}
