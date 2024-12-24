package com.dw.jdbcapp.repository.iface;

import com.dw.jdbcapp.dto.ProductDTO;
import com.dw.jdbcapp.model.Product;

import java.util.List;

public interface  ProductRepository {
    List<Product> getAllProducts();

    Product getProductById(int id);

    Product saveProduct(Product product);

    Product updateProduct(Product product);

    String deleteProduct(String id);

    String updateProductWithStock(int id, int stock);

    List<Product> getProductByProductName(String name);

     List<Product> getProductsByStockValue();

}
