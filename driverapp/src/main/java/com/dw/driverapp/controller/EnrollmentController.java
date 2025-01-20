package com.dw.driverapp.controller;

import com.dw.driverapp.dto.EnrollmentDTO;
import com.dw.driverapp.service.BoardService;
import com.dw.driverapp.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnrollmentController {
    @Autowired
    EnrollmentService enrollmentService;

    // 유저 -> 모든 수강신청 내역 조회
    @GetMapping("/enrollment/all")
    private ResponseEntity<List<EnrollmentDTO>> getAllEnrollment(){
        return new ResponseEntity<>(enrollmentService.getAllEnrollment(), HttpStatus.OK);
    }
    // 유저 -> 과목 ID로 수강신청 내역 조회
    @GetMapping("/enrollment/{id}")
    private ResponseEntity<List<EnrollmentDTO>> getSubjectId(@PathVariable Long id){
        return new ResponseEntity<>(enrollmentService.getSubjectId(id),HttpStatus.OK);
    }


}
