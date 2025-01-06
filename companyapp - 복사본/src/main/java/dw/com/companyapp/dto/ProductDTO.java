package dw.com.companyapp.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProductDTO {
    private Long productId;
    private String productName;
    private double unitPrice;
    private int stock;
    private String pkgUnit;
    private double stockValue = unitPrice * stock; // 재고금액 = 단가 * 재고
}
