package dw.com.companyapp.repository;

import dw.com.companyapp.model.MileageGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MileGradeRepository extends JpaRepository<MileageGrade,String> {
}
