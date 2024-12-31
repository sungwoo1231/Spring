package com.dw.jpaapp.repository;

import com.dw.jpaapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByTitleLike(String title); // 메서드 쿼리

}