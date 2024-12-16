package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.dto.EmployeeDepartmentDTO;
import com.dw.jdbcapp.model.Employee;
import com.dw.jdbcapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/find-all-employee")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    // Query Parameters (쿼리문자열)
    @GetMapping("/employee")
    public Employee getEmployeeById(@RequestParam String id){
        return employeeService.getEmployeeById(id);
    }
    // Path Parameters (경로 매개변수)
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById_2(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }

   @GetMapping("/employee/department")
    public List<Map<String, Object>> getEmployeesWithDepartName(){
        return employeeService.getEmployeesWithDepartName();
    }
    @GetMapping ("/employees/department2")
    public List<EmployeeDepartmentDTO> getEmployeesWithDepartName2(){
        return employeeService.getEmployeesWithDepartName2();
    }
    // Query Parameters (쿼리문자열)
    @GetMapping("/api/employees/{id}/{position}")
    public Employee getDepartmentById_3(@PathVariable String id, @PathVariable String position){
        return employeeService.getEmployeeById_3(id,position);
    }
    // Path Parameters (경로 매개변수)
    @GetMapping("api/employees")
    public Employee getDepartmentById_4(@RequestParam String id, @RequestParam String position){
        return employeeService.getEmployeeById_3(id,position);
    }

    // Post
    @PostMapping("/api/post/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
}
