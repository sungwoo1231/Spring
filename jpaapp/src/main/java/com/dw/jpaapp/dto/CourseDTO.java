package com.dw.jpaapp.dto;

import com.dw.jpaapp.model.Instructor;
import com.dw.jpaapp.model.Student;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private Long instructorId;
    private List<Long> studentIds = new ArrayList<>();
}