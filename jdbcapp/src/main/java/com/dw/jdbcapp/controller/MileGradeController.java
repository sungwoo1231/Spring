package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.model.MileGrade;
import com.dw.jdbcapp.service.MileGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MileGradeController {
    @Autowired
    MileGradeService mileGradeService;

    @GetMapping("/find-all-milegrade")
    public List<MileGrade> getAllMileGrades(){
        return mileGradeService.getAllMileGrades();
    }
}
