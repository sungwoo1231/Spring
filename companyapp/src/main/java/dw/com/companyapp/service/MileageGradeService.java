package dw.com.companyapp.service;


import dw.com.companyapp.model.MileageGrade;
import dw.com.companyapp.repository.MileGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MileageGradeService {
@Autowired
    MileGradeRepository mileGradeRepository;
    public List<MileageGrade> getAllMileages() {
        return mileGradeRepository.findAll();
    }
}
