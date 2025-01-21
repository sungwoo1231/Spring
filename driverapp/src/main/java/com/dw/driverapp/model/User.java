
package com.dw.driverapp.model;

import com.dw.driverapp.dto.UserDTO;
import com.dw.driverapp.dto.UserPointDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="사용자")
public class User {
    @Id
    @Column(name="user_name")
    private String userName;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="email", nullable = false, unique = true)
    private String email;
    @Column(name = "real_name", nullable = false)
    private String realName;
    @Column(name="birthdate",nullable = false, unique = true)
    private LocalDate birthdate;
    @ManyToOne
    @JoinColumn(name = "user_authority")
    private Authority authority;
    @Column(name="created_at", updatable = false)
    private LocalDate createdAt;
    @Column(name="point")
    private int point;
    @Column(name="last_login_date")
    private LocalDate lastLoginDate;  // 마지막 로그인 날짜




    public UserDTO toDTO() {
        return new UserDTO(
                this.userName,
                null,
                this.email,
                this.realName,
                this.birthdate,
                authority.getAuthorityName(),
                this.point,
                this.lastLoginDate

        );
    }
        public UserPointDTO todto(){
            return new UserPointDTO(
                    this.userName,
                    this.point
            );

    }
}
