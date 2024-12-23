package com.dw.jdbcapp.repository.iface;

import com.dw.jdbcapp.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderRepository {
    List<Order> getAllOrders();

    Order getOrderById(String id);

    List<Order> getOrderById_2(int number,String id );

    int saveOrder(Order order);

    String updateOrderWithShippingDate(String id,String date);
    List<Map<String,Double>> getTopCitiesByTotalOrderAmount(int limit);
}