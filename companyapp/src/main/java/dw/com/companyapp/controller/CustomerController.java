package dw.com.companyapp.controller;


import dw.com.companyapp.model.Customer;
import dw.com.companyapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/find-all-customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(
                customerService.getAllCustomers(), // 첫번째 매개변수는 데이터
                HttpStatus.OK);
    }

    // 과제 4-1 전체 평균마일리지보다 큰 마일리지를 가진 고객들을 조회하는 API
    @GetMapping("/customers/high-mile-than-avg")
    public ResponseEntity<List<Customer>> getCustomersWithHighMileThanAvg() {
        return new ResponseEntity<>(
                customerService.getCustomersWithHighMileThanAvg(),
                HttpStatus.OK);
    }

    // 과제 4-2 마일리지등급을 매개변수로 해당 마일리지등급을 가진 고객들을 조회하는 API
    @GetMapping("/customers/grade/{grade}")
    public ResponseEntity<List<Customer>> getCustomersByMileageGrade(
            @PathVariable String grade) {
        return new ResponseEntity<>(
                customerService.getCustomersByMileageGrade(grade),
                HttpStatus.OK);
    }
}





