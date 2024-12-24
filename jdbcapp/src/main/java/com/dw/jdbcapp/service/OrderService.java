package com.dw.jdbcapp.service;

import com.dw.jdbcapp.dto.OrderRequestDTO;
import com.dw.jdbcapp.exception.InvalidRequestException;
import com.dw.jdbcapp.model.Order;
import com.dw.jdbcapp.model.OrderDetail;
import com.dw.jdbcapp.model.Product;
import com.dw.jdbcapp.repository.iface.OrderDetailRepository;
import com.dw.jdbcapp.repository.iface.OrderRepository;
import com.dw.jdbcapp.repository.iface.ProductRepository;
import com.dw.jdbcapp.repository.jdbc.OrderJdbcRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class OrderService {
    @Autowired
    @Qualifier("orderTemplateRepository")
    OrderRepository orderRepository;

    @Autowired
    @Qualifier("orderDetailTemplateRepository")
    OrderDetailRepository orderDetailRepository;

    @Autowired
    @Qualifier("productTemplateRepository")
    ProductRepository productRepository;

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

    @Transactional // @Transactional은 선언된 메서드 수행도중 예외가 발생하면 이미 수행되었던
                   // 동작을 모두 롤백(원상복구) 시키도록 명령하는 어노테이션
                   // 주문세부의 특정 제품의 재고가 부족해서 예외가 발생하면 전체 주문, 주문세부의
                   // 저장되었던 내용들은 모두 취소되고 롤백됨!!
    public OrderRequestDTO getSaveOrder(OrderRequestDTO orderRequestDTO) {
        orderRepository.saveOrder(orderRequestDTO.toOrder());
        for (OrderDetail data : orderRequestDTO.getOrderDetails()) {
            Product product = productRepository.getProductById(data.getProductNum());
            System.out.println(product.getStock() + " " + data.getOrderQuantity());

            if (product.getStock() - data.getOrderQuantity() < 0 ) {
                throw new InvalidRequestException(
                        "요청하신 수량은 현재 재고를 초과합니다: " + product.getProductName() + ", 현재 재고: " +
                                product.getStock());
            } else {
                orderDetailRepository.saveOrderDetail(data);
            }
        }
        return orderRequestDTO;
    }
}