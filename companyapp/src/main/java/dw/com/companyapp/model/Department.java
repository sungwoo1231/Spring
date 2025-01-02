package dw.com.companyapp.model;

import dw.com.companyapp.dto.DepartmentDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="부서")
public class Department {
    @Id
    @Column(name="부서번호")
    private String departmentId;
    @Column(name="부서명")
    private String departmentName;

    public DepartmentDTO toDTO(Department department){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentId(this.departmentId);
        departmentDTO.setDepartmentName(this.departmentName);
        return departmentDTO;
    }
}
