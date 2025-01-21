package com.dw.driverapp.repository;

import com.dw.driverapp.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {

    Optional<List<Enrollment>> findBySubjectId(Long id);
    List<Enrollment> findByUser_UserName(String username);


}
