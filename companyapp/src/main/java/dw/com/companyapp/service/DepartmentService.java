package dw.com.companyapp.service;


import dw.com.companyapp.model.Department;
import dw.com.companyapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department saveDepartment(Department department) {
        Department department1 = new Department();
        department1.setDepartmentId(department.getDepartmentId());
        department1.setDepartmentName(department.getDepartmentName());

        return departmentRepository.save(department);
    }

    public List<Department> saveDepartmentList(List<Department> departmentList) {
        List<Department> DepartmentList = new ArrayList<>();
        for (Department data : departmentList) {
            Department Department = departmentRepository.save(data);

            DepartmentList.add(Department); // 저장된 데이터를 리스트에 추가
        }

        return DepartmentList;
    }

    public Department updateDepartment(Department department) {
        // 1. 부서 ID를 기준으로 기존 부서를 조회합니다.
        Department Department = departmentRepository.findById(department.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        // 2. 기존 부서의 정보를 수정합니다.
        Department.setDepartmentId(department.getDepartmentId());  // 부서 ID 수정
        Department.setDepartmentName(department.getDepartmentName());  // 부서 이름 수정

        // 3. 수정된 부서를 저장합니다.
        return departmentRepository.save(Department);  // 업데이트된 부서 저장
    }

    public String deleteDepartment(String id) {
    Department department = departmentRepository.findById(id).
            orElseThrow(() -> new RuntimeException("Not Found"));

        departmentRepository.delete(department);

        return id;
    }
}








