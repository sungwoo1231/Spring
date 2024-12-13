package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.model.Employee;
import com.dw.jdbcapp.model.Product;
import com.dw.jdbcapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
