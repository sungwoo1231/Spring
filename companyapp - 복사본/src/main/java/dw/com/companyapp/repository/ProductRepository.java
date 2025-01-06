package dw.com.companyapp.repository;

import dw.com.companyapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select p from Product p where p.unitPrice < :price")
    List<Product> getProductsBelowPrice(double price);

    @Query("select p from Product p where p.productName like :name")
    List<Product> findByProductNameLike(String name);

List<Product> findByProductId(Long productId);
}
