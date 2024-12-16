package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.model.Department;
import com.dw.jdbcapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    // Get(select)
    @GetMapping("/find-all-department")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    // Post (insert)
    // single data (저장할 데이터 객체 1개 처리)
    @PostMapping("/post/department")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    // multiple data (저장할 데이터가 리스트임) (여러개)
    @PostMapping("/post/departmentlist")
    public List<Department> saveDepartmentlist(@RequestBody List<Department> departmentList){
        return departmentService.saveDepartmentlist(departmentList);
    }

    // Put (update)
    @PutMapping("/put/department")
    public Department updateDepartment(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }

    // Delete
    @DeleteMapping("/delete/department/id/{id}")
    public String deleteDepartment(@PathVariable String id){
        return "부서번호 : " + departmentService.deleteDepartment(id)
                + " 가 삭제되었습니다.";
    }

}

