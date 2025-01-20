package com.dw.driverapp.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EnrollmentDTO {
    private Long id;
    private String username;
    private Long subjectId;
    private LocalDateTime purchaseTime;

}
