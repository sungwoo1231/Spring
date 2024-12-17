package com.dw.jdbcapp.repository.iface;

import com.dw.jdbcapp.model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> getAllOrders();

    Order getOrderById(String id);

    Order getOrderById_2(String number,String id );
}
