package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.dto.ProductDTO;
import com.dw.jdbcapp.model.Employee;
import com.dw.jdbcapp.model.Product;
import com.dw.jdbcapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productControllerService;

    @GetMapping("/find-all-product")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productControllerService.getAllProducts(), HttpStatus.OK);

    }


    // Path Parameters (경로 매개변수)
    @GetMapping("/api/products/{id}")
    public ResponseEntity< Product> getProductById(@PathVariable int id){
        return new ResponseEntity<>(productControllerService.getProductById(id),HttpStatus.OK);
    }
    // Query Parameters (쿼리문자열)
    @GetMapping("/api/products")
    public ResponseEntity<Product> getProductById_2(@RequestParam int id){
        return new ResponseEntity<>(productControllerService.getProductById(id),HttpStatus.OK);
    }

    // Post(insert)
    @PostMapping("/api/post/product")
    public ResponseEntity< Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>( productControllerService.saveProduct(product),HttpStatus.CREATED);
    }
    // Post
    // Multiple data
    @PostMapping("/api/post/productlist")
    public ResponseEntity< List<Product>> saveProductList(@RequestBody List<Product> productList){
        return new ResponseEntity<>(productControllerService.saveProductList(productList),HttpStatus.CREATED);
    }

    // Put(update)
    @PutMapping("/put/proudct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>( productControllerService.updateProduct(product),HttpStatus.OK);
    }
    // Delete // 80번 삭제
    @DeleteMapping("/api/delete/product/id/{id}")
    public ResponseEntity<String> deleteProduct (@PathVariable String id) {
        return new ResponseEntity<>("제품번호 : " + productControllerService.deleteProduct(id)
                + " 가 삭제되었습니다.",HttpStatus.OK );
    }
    @PutMapping("/api/products/update")
    public ResponseEntity<String> updateProductWithStock(@RequestParam int id, @RequestParam int stock){
        return new ResponseEntity<>(productControllerService.updateProductWithStock(id,stock),HttpStatus.OK);
    }
    @GetMapping("/api/products/name/{name}")
    public ResponseEntity <List<Product>> getProductByProductName(@PathVariable String name){
        return new ResponseEntity<>(productControllerService.getProductByProductName(name),HttpStatus.OK);
    }
    @GetMapping("/api/products/stockvalue")
    public ResponseEntity<ProductDTO> getProductsByStockValue(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productControllerService.getProductsByStockValue(productDTO),HttpStatus.OK);
    }

}
