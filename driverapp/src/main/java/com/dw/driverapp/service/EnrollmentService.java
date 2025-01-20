package com.dw.driverapp.service;

import com.dw.driverapp.dto.EnrollmentDTO;
import com.dw.driverapp.exception.ResourceNotFoundException;
import com.dw.driverapp.model.Enrollment;
import com.dw.driverapp.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    @Autowired
    EnrollmentRepository enrollmentRepository;

    public List<EnrollmentDTO> getAllEnrollment(){
        return enrollmentRepository.findAll().stream().map(Enrollment::toDTO).toList();
    }

    // 유저 -> 과목 ID로 수강신청 내역 조회
    public  List<EnrollmentDTO> getSubjectId(Long id){
        return enrollmentRepository.findBySubjectId(id)
                .filter(enrollments -> !enrollments.isEmpty())
                .orElseThrow(()-> new ResourceNotFoundException("존재하지 않는 과목입니다."))
                .stream()
                .map(Enrollment::toDTO)
                .toList();
    }
}
