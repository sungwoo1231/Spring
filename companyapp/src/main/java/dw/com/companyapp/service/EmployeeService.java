package dw.com.companyapp.service;


import dw.com.companyapp.dto.EmployeeDepartmentDTO;
import dw.com.companyapp.exception.InvalidRequestException;
import dw.com.companyapp.exception.ResourceNotFoundException;
import dw.com.companyapp.model.Employee;
import dw.com.companyapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // 과제 3-1 사원정보를 조회할때 사원번호가 올바르지 않은 경우의 예외 처리
    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id)
                .orElseThrow(()-> new InvalidRequestException("사원번호가 올바르지 않습니다"));
    }

    public  List<EmployeeDepartmentDTO>getEmployeesWithDepartName() {
        return employeeRepository.findAll().stream().map(Employee::toDTO).toList();
    }

    public List<EmployeeDepartmentDTO> getEmployeesWithDepartName2() {
        return  employeeRepository.findAll().stream().map(Employee::toDTO).toList();
    }

    // 과제 1-3 부서번호와 직위를 기준으로 해당 부서에 근무하는 특정 직위의 사원 정보를 조회하는 API
    // 과제 3-3 부서번호와 직위로 사원정보를 조회할때 데이터가 없는 경우의 예외처리
    public List<Employee> getEmployeesWithDepartmentAndPosition(String departmentNumber, String position){
        List<Employee> employees = employeeRepository.findByDepartmentNumberAndPosition(departmentNumber,position).stream().toList();
        if (employees.isEmpty()){
            throw new ResourceNotFoundException("사원번호가 올바르지 않습니다");
        }
        return employees;
    }

    // 과제 2-3 사원테이블에 사원 1명을 새로 추가하는 API
    public Employee saveEmployee(Employee employee) {
//        Employee employee1 = new Employee();
//        employee1.setEmployeeId(employee.getEmployeeId());
//        employee1.setName(employee.getName());
//        employee1.setEnglishName(employee.getEnglishName());
//        employee1.setPosition(employee.getPosition());
//        employee1.setGender(employee.getGender());
//        employee1.setBirthDate(employee.getBirthDate());
//        employee1.setHireDate(employee.getHireDate());
//        employee1.setAddress(employee.getAddress());
//        employee1.setCity(employee.getCity());
//        employee1.setRegion(employee.getRegion());
//        employee1.setPhoneNumber(employee.getPhoneNumber());
//        employee1.setSupervisorId(employee.getSupervisorId());
//        employee1.setDepartment(employee.getDepartment());
        return employeeRepository.save(employee);
    }

    // 과제 4-3 입사일을 매개변수로 해당 입사일 이후로 입사한 사원들을 조회하는 API
    // hiredate를 0으로 입력하면 가장 최근 입사한 사원의 정보를 조회하시오.
    public List<Employee> getEmployeesByHiredate(String hiredate) {
        if (hiredate.equals("0")) {

            return employeeRepository.findByHireDate2();
        }

        LocalDate hireDate = LocalDate.parse(hiredate);
        return employeeRepository.findByHireDate(hireDate);
    }
}







