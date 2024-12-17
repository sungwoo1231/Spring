package com.dw.jdbcapp.service;

import com.dw.jdbcapp.model.Department;
import com.dw.jdbcapp.repository.iface.DepartmentRepository;
import com.dw.jdbcapp.repository.jdbc.DepartmentJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    @Qualifier("departmentTemplateRepository")
    DepartmentRepository departmentRepository;


    public List<Department> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

    // Post(insert)
    public Department saveDepartment(Department department) {
        return departmentRepository.saveDepartment(department);
    }

    // Post(insert)
     // multiple data
    public List<Department> saveDepartmentlist(List<Department> departmentList){
        for (Department data : departmentList) {
            departmentRepository.saveDepartment(data);
        }
        return departmentList;
    }

    // Put(update)
    public Department updateDepartment(Department department){
        return departmentRepository.updateDepartment(department);
    }

    // Delete
    public String deleteDepartment(String id){
        return departmentRepository.deleteDepartment(id);
    }
}

