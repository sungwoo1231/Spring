package com.dw.jdbcapp.service;

import com.dw.jdbcapp.dto.EmployeeDepartmentDTO;
import com.dw.jdbcapp.model.Employee;
import com.dw.jdbcapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.getAllEmployees();
    }

    public Employee getEmployeeById(String id){
        return employeeRepository.getEmployeeById(id);
    }

    public List<Map<String,Object>> getEmployeesWithDepartName(){
        return employeeRepository.getEmployeesWithDepartName();
    }

    public List<EmployeeDepartmentDTO> getEmployeesWithDepartName2(){
        List<EmployeeDepartmentDTO> employeeDepartmentDTOList =
                new ArrayList<>();

        List<Map<String,Object>> mapList =
                employeeRepository.getEmployeesWithDepartName();

        for (Map<String,Object> data : mapList) {
            EmployeeDepartmentDTO temp = new EmployeeDepartmentDTO(
                LocalDate.parse((String)data.get("입사일")),
                        (String)data.get("부서명"),
                        (String)data.get("이름"));

                employeeDepartmentDTOList.add(temp);

           }
        return employeeDepartmentDTOList;
    }
    public Employee getEmployeeById_3(String id,String position){
        return employeeRepository.getDepartmentById_3(id, position);
    }
}
