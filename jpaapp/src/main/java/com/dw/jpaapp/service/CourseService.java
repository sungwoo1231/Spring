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
import jakarta.persistence.Id;
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
    @Autowired
    StudentRepository studentRepository;


    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(Course::toDTO)
                .collect(Collectors.toList());
    }

    public List<CourseDTO> getCoursesLike(String title) {
        return courseRepository.findByTitleLike( "%" +title + "%").stream().map(Course::toDTO).toList();

    }

    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setDescription(courseDTO.getDescription());
        course.setInstructor_fk(instructorRepository.findById(courseDTO.getInstructorId())
                .orElseThrow(()->new RuntimeException("No instructor")));

//        Instructor instructor = instructorRepository
//                .findById(courseDTO.getInstructorId())
//                .orElseThrow(()->new RuntimeException("No instructor"));
//        course.setInstructor_fk(instructor);

        List<Student> students = new ArrayList<>();
        for (Long id : courseDTO.getStudentIds()) {
            students.add(studentRepository.findById(id)
                    .orElseThrow(()->new RuntimeException("No student")));
        }
        course.setStudentList(students);

        return courseRepository.save(course).toDTO();
    }
}