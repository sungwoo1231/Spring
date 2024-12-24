package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.dto.OrderRequestDTO;
import com.dw.jdbcapp.model.Order;
import com.dw.jdbcapp.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/find-all-order")
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    // Path Parameters (경로 매개변수)
    @GetMapping("/api/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id){
        return new ResponseEntity<>(orderService.getOrderById(id),HttpStatus.OK);
    }
    // Query Parameters (쿼리문자열)
    @GetMapping("/api/orders")
    public ResponseEntity<Order> getOrderById_2(@RequestParam String id){
        return new ResponseEntity<>(orderService.getOrderById(id),HttpStatus.OK);
    }

    @GetMapping("/api/orders/{number}/{id}")
    public ResponseEntity<List<Order>> getOrderById_2(@PathVariable int number,@PathVariable String id){
        return new ResponseEntity<>(orderService.getOrderById_2(number,id),HttpStatus.OK);
    }
    @GetMapping("/api/orders/query") // /api/orders/query?number=11&id=NETVI
    public ResponseEntity <List<Order>> getOrderById(@RequestParam int number,@RequestParam String id){
        return new ResponseEntity<>(orderService.getOrderById_2(number,id),HttpStatus.OK);
    }
    @PostMapping("/orders")
    public ResponseEntity<OrderRequestDTO> saveOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        return new ResponseEntity<>(orderService.saveOrder(orderRequestDTO),HttpStatus.CREATED);
    }
    @PutMapping("/api/orders/update")
    public ResponseEntity<String> updateOrderWithShippingDate(@RequestParam String id,@RequestParam String date){
        return new ResponseEntity<>(orderService.updateOrderWithShippingDate(id,date),HttpStatus.OK);
    }

    @GetMapping("/api/orders/city/orderamount/{limit}")
    public ResponseEntity <List<Map<String,Double>>> getTopCitiesByTotalOrderAmount(@PathVariable int limit){
        return new ResponseEntity<>(orderService.getTopCitiesByTotalOrderAmount(limit),HttpStatus.OK);
    }
    @GetMapping("/api/orders/ordercount/year/{city}")
    public ResponseEntity  <List<Map<String,Double>>> getOrderCountByYearForCity(@PathVariable String city){
        return new ResponseEntity<>(orderService.getOrderCountByYearForCity(city),HttpStatus.OK);
    }
    @PostMapping("/post/orders")
    public ResponseEntity<OrderRequestDTO> getSaveOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        return new ResponseEntity<>(
                orderService.getSaveOrder(orderRequestDTO),HttpStatus.OK);
    }

}