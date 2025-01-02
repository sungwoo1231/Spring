package dw.com.companyapp.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class EmployeeDepartmentDTO {
    private LocalDate hireDate;
    private String departmentName;
    private String employeeName;
}
