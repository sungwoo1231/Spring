package com.dw.jdbcapp.service;

import com.dw.jdbcapp.model.Customer;
import com.dw.jdbcapp.repository.iface.CustomerRepository;
import com.dw.jdbcapp.repository.jdbc.CustomerJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerService {
    @Autowired
    // 어노테이션을 이용한 방법
    @Qualifier("customerTemplateRepository")
    CustomerRepository custmoerRepostitory;

    public List<Customer> getAllCustomers(){
        return custmoerRepostitory.getAllCustomers();
    }
}
