package com.dw.jdbcapp.service;

import com.dw.jdbcapp.dto.EmployeeDepartmentDTO;
import com.dw.jdbcapp.exception.InvalidRequestException;
import com.dw.jdbcapp.model.Employee;
import com.dw.jdbcapp.repository.iface.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    @Qualifier("employeeTemplateRepository")
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id);
    }

    public List<Map<String, Object>> getEmployeesWithDepartName() {
        return employeeRepository.getEmployeesWithDepartName();
    }

    public List<EmployeeDepartmentDTO> getEmployeesWithDepartName2() {
        List<EmployeeDepartmentDTO> employeeDepartmentDTOList =
                new ArrayList<>();

        List<Map<String, Object>> mapList =
                employeeRepository.getEmployeesWithDepartName();

        for (Map<String, Object> data : mapList) {
            EmployeeDepartmentDTO temp = new EmployeeDepartmentDTO(
                    LocalDate.parse((String) data.get("입사일")),
                    (String) data.get("부서명"),
                    (String) data.get("이름"));

            employeeDepartmentDTOList.add(temp);

        }
        return employeeDepartmentDTOList;
    }

    public List<Employee> getEmployeeById_3(String id, String position) {
        return employeeRepository.getDepartmentById_3(id, position);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.saveEmployee(employee);
    }

    public List<Employee> getEmployeesByHiredate(String hiredate) {
            if (hiredate.equals("0")){
                return employeeRepository.getEmployeesByHiredate1();
            }
            try {
                LocalDate hiredate2 = LocalDate.parse(hiredate);
                return employeeRepository.getEmployeesByHiredate(hiredate2.toString());
            } catch (DateTimeException e) {
                throw new InvalidRequestException("입력하신 입사일이 올바르지 않습니다" + hiredate);
            }

        }
    }
