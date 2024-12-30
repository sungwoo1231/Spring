package com.dw.jpaapp.service;

import com.dw.jpaapp.dto.CourseDTO;
import com.dw.jpaapp.dto.InstructorDTO;
import com.dw.jpaapp.dto.StudentDTO;
import com.dw.jpaapp.model.Course;
import com.dw.jpaapp.model.Instructor;
import com.dw.jpaapp.model.Student;
import com.dw.jpaapp.repository.CourseRepository;
import com.dw.jpaapp.repository.InstructorRepository;
import com.dw.jpaapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    InstructorRepository instructorRepository;


    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(Course::toDTO)
                .collect(Collectors.toList());
    }
    public List<CourseDTO> getCoursesLike(String title){
        String title1 = "%" + title + "%";
        return courseRepository.findByTitleLike(title1).stream().map(Course::toDTO).toList();


        }
        public CourseDTO saveCourse(){
        Course course = new Course();
        course.setTitle(course.getTitle());
        }
  }
