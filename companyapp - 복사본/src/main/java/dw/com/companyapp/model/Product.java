package dw.com.companyapp.model;

import dw.com.companyapp.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="제품")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="제품번호")
    private long productId;
    @Column(name="제품명")
    private String productName;
    @Column(name="포장단위")
    private String pkgUnit;
    @Column(name="단가")
    private double unitPrice;
    @Column(name="재고")
    private int stock;

    public ProductDTO toDTO(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(this.productId);
        productDTO.setProductName(this.productName);
        productDTO.setPkgUnit(this.pkgUnit);
        productDTO.setUnitPrice(this.unitPrice);
        productDTO.setStock(this.stock);
        productDTO.setStockValue(this.unitPrice*this.stock);
        return productDTO;
    }
}
