package com.dw.jdbcapp.repository.iface;

import com.dw.jdbcapp.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    List<Map<String, Object>> getEmployeesWithDepartName();

    Employee getDepartmentById_3(String id, String position);

    Employee saveEmployee(Employee employee);
}
