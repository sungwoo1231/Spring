package com.dw.driverapp.dto;

import com.dw.driverapp.model.Subject;
import com.dw.driverapp.model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CartDTO {
    private Long id;
    private String subjectTitle;
    private String username;
    private Double price;

}
