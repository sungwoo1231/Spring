package dw.com.companyapp.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProductDTO {
    private int productId;
    private String productName;
    private double unitPrice;
    private int stock;
    private double stockValue; // 재고금액 = 단가 * 재고
}
