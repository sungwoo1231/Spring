package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.dto.EmployeeDepartmentDTO;
import com.dw.jdbcapp.model.Employee;
import com.dw.jdbcapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/find-all-employee")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    // Query Parameters (쿼리문자열)
    @GetMapping("/employee")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam String id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }
    // Path Parameters (경로 매개변수)
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById_2(@PathVariable String id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

   @GetMapping("/employee/department")
    public ResponseEntity<List<Map<String, Object>>> getEmployeesWithDepartName(){
        return new ResponseEntity<>(employeeService.getEmployeesWithDepartName(),HttpStatus.OK);
    }
    @GetMapping ("/employees/department2")
    public ResponseEntity<List<EmployeeDepartmentDTO>> getEmployeesWithDepartName2(){
        return new ResponseEntity<>(employeeService.getEmployeesWithDepartName2(),HttpStatus.OK);
    }

    // Path Parameters (경로 매개변수)
    @GetMapping("/api/employees/{id}/{position}")
    public ResponseEntity<List<Employee>> getDepartmentById_3(@PathVariable String id, @PathVariable String position){
        return new ResponseEntity<>(employeeService.getEmployeeById_3(id, position),HttpStatus.OK);
    }

    // Query Parameters (쿼리문자열)
    @GetMapping("/api/employees")
    public ResponseEntity <List<Employee>> getDepartmentById_4(@RequestParam String id, @RequestParam String position){
        return new ResponseEntity<>(employeeService.getEmployeeById_3(id,position),HttpStatus.OK);
    }

    // Post
    @PostMapping("/api/post/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
    }

}
