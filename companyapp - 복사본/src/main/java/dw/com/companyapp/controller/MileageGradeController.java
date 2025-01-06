package dw.com.companyapp.controller;


import dw.com.companyapp.model.MileageGrade;
import dw.com.companyapp.service.MileageGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MileageGradeController {
    @Autowired
    MileageGradeService mileGradeService;

    @GetMapping("/find-all-mileage")
    public ResponseEntity<List<MileageGrade>> getAllMileages() {
        return new ResponseEntity<>(
                mileGradeService.getAllMileages(),
                HttpStatus.OK);
    }
}
