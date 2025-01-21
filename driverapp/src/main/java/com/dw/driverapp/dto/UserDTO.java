package com.dw.driverapp.dto;

import com.dw.driverapp.model.Authority;
import com.dw.driverapp.model.Board;
import com.dw.driverapp.model.Subject;
import com.dw.driverapp.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private String userName;
    private String password;
    private String email;
    private String realName;
    private LocalDate birthdate;
    private String role;
    private int point;
    private LocalDate lastLoginDate;
    private String authority;


    public UserDTO(String userName, Object o, String email, String realName, LocalDate birthdate, String authorityName, int point, LocalDate lastLoginDate) {
    }
}