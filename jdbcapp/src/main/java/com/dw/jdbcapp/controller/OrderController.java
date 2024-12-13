package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.model.Order;
import com.dw.jdbcapp.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/find-all-order")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    // Path Parameters (경로 매개변수)
    @GetMapping("/api/orders/{id}")
    public Order getOrderById(@PathVariable String id){
        return orderService.getOrderById(id);
    }
    // Query Parameters (쿼리문자열)
    @GetMapping("/api/orders")
    public Order getOrderById_2(@RequestParam String id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/api/orders/{number}/{id}")
    public Order getOrderById_2(@PathVariable String number,@PathVariable String id){
        return orderService.getOrderById_2(number,id);
    }
  @GetMapping("/api/orders/query") // /api/orders/query?number=11&id=NETVI
    public Order getOrderById(@RequestParam String number,@RequestParam String id){
        return orderService.getOrderById_2(number,id);
  }

}
