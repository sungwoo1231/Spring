package com.dw.jdbcapp.service;

import com.dw.jdbcapp.dto.OrderRequestDTO;
import com.dw.jdbcapp.model.Order;
import com.dw.jdbcapp.model.OrderDetail;
import com.dw.jdbcapp.repository.iface.OrderDetailRepository;
import com.dw.jdbcapp.repository.iface.OrderRepository;
import com.dw.jdbcapp.repository.jdbc.OrderJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    @Qualifier("orderTemplateRepository")
    OrderRepository orderRepository;

    @Autowired
    @Qualifier("orderDetailTemplateRepository")
    OrderDetailRepository orderDetailRepository;

    public List<Order> getAllOrders(){
        return orderRepository.getAllOrders();
    }

    public Order getOrderById(String id){
        return orderRepository.getOrderById(id);
    }
    public List<Order> getOrderById_2(int number,String id){
        return orderRepository.getOrderById_2(number,id);
    }
    public OrderRequestDTO saveOrder(OrderRequestDTO orderRequestDTO){
        // 1. DTO에서 주문정보를 꺼내 주문테이블에 insert
        orderRepository.saveOrder(orderRequestDTO.toOrder());
        // 2. DTO에서 주문세부정보를 꺼내서 주문세부테이블에 insert.반복문 필요
        for (OrderDetail data : orderRequestDTO.getOrderDetails()){
            orderDetailRepository.saveOrderDetail(data);
        }
        return orderRequestDTO;
    }
    public String updateOrderWithShippingDate(String id, String date){
        return orderRepository.updateOrderWithShippingDate(id,date);
    }
    public List<Map<String,Double>> getTopCitiesByTotalOrderAmount(int limit){
        return orderRepository.getTopCitiesByTotalOrderAmount(limit);
    }
    public List<Map<String,Double>> getOrderCountByYearForCity(String city){
        return orderRepository.getOrderCountByYearForCity(city);
    }

}