package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.model.Customer;
import com.dw.jdbcapp.service.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/find/all/customer")
    public ResponseEntity <List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(), // 첫 번째 매개변수는 데이터
                HttpStatus.OK); // 두 번째는 상태 코드
    }

    @GetMapping("/customers/high-mile-than-avg")
    public ResponseEntity<List<Customer>>getCustomersWithHighMileThanAvg(){
        return new ResponseEntity<>(customerService.getCustomersWithHighMileThanAvg(),HttpStatus.OK);
    }
    @GetMapping("/customers/grade/{grade}")
    public ResponseEntity<List<Customer>>getCustomersByMileageGrade(@PathVariable String grade){
        return new ResponseEntity<>(customerService.getCustomersByMileageGrade(grade),HttpStatus.OK);
    }
}