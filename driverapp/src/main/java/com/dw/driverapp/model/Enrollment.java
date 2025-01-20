package com.dw.driverapp.model;

import com.dw.driverapp.dto.EnrollmentDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="수강신청")
public class Enrollment {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="user_name")
    private User user;
     @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subject;
    @Column(name="purchase_time")
    private LocalDateTime purchaseTime;

    public EnrollmentDTO toDTO(){
        EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
        enrollmentDTO.setId(this.id);
        enrollmentDTO.setUsername(this.user.getUserName());
        enrollmentDTO.setPurchaseTime(this.purchaseTime);
        enrollmentDTO.setSubjectId(this.subject.getId());
        return enrollmentDTO;

    }
}
