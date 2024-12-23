package com.dw.jdbcapp.service;

import com.dw.jdbcapp.dto.ProductDTO;
import com.dw.jdbcapp.exception.InvalidRequestException;
import com.dw.jdbcapp.model.Product;
import com.dw.jdbcapp.repository.iface.ProductRepository;
import com.dw.jdbcapp.repository.jdbc.ProductJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    @Qualifier("productTemplateRepository")
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();

    }

    public Product getProductById(int id) {
        if (id < 0) {
            throw new InvalidRequestException("존재하지 않는 제품번호:" + id);
        }
        return productRepository.getProductById(id);
    }

    // Post(insert)
    public Product saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }

    // Post
    // Multiple data
    public List<Product> saveProductList(List<Product> productList) {
        for (Product data : productList) {
            productRepository.saveProduct(data);
        }
        return productList;
    }

    // Put
    public Product updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }

    // Delete
    public String deleteProduct(String id) {
        return productRepository.deleteProduct(id);
    }


    public String updateProductWithStock(int id, int stock) {
        return productRepository.updateProductWithStock(id, stock);
    }

    public List<Product> getProductByProductName(String name) {
        return productRepository.getProductByProductName(name);
    }

    public void temp() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(0);
        productDTO.setProductName("");
        productDTO.setUnitPrice(0);
        productDTO.setStock(0);
        productDTO.setStockValue(productDTO.getStock()* productDTO.getUnitPrice());
    }
}