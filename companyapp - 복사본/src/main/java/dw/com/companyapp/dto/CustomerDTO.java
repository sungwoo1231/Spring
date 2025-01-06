package dw.com.companyapp.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CustomerDTO {
    private String customerId;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String phoneNumber;
    private int mileage;
    private List<String> mileageGradeIds = new ArrayList<>();
}
