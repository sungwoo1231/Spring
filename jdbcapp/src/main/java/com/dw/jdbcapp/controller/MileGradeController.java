package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.model.MileGrade;
import com.dw.jdbcapp.service.MileGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MileGradeController {
    @Autowired
    MileGradeService mileGradeService;

    @GetMapping("/find-all-milegrade")
    public ResponseEntity<List<MileGrade>> getAllMileGrades(){
        return new ResponseEntity<>(mileGradeService.getAllMileGrades(), HttpStatus.OK);
    }
}
