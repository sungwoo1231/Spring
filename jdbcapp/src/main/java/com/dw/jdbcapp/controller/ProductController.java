package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.model.Employee;
import com.dw.jdbcapp.model.Product;
import com.dw.jdbcapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productControllerService;

    @GetMapping("/find-all-product")
    public List<Product> getAllProducts(){
        return productControllerService.getAllProducts();

    }


    // Path Parameters (경로 매개변수)
    @GetMapping("/api/products/{id}")
    public Product getProductById(@PathVariable int id){
        return productControllerService.getProductById(id);
    }
    // Query Parameters (쿼리문자열)
    @GetMapping("/api/products")
    public Product getProductById_2(@RequestParam int id){
        return productControllerService.getProductById(id);
    }

    // Post(insert)
    @PostMapping("/api/post/product")
    public Product saveProduct(@RequestBody Product product){
        return productControllerService.saveProduct(product);
    }
    // Post
    // Multiple data
    @PostMapping("/api/post/productlist")
    public List<Product> saveProductList(@RequestBody List<Product> productList){
        return productControllerService.saveProductList(productList);
    }

    // Put(update)
    @PutMapping("/api/put/proudct")
    public Product updateProduct(@RequestBody Product product){
        return productControllerService.updateProduct(product);
    }
    // Delete // 80번 삭제
    @DeleteMapping("/api/delete/product/id/{id}")
    public String deleteProduct (@PathVariable String id) {
        return "제품번호 : " + productControllerService.deleteProduct(id)
                + " 가 삭제되었습니다.";
    }
}
