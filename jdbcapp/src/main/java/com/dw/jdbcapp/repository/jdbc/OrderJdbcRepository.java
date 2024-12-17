package com.dw.jdbcapp.repository.jdbc;

import com.dw.jdbcapp.model.Order;
import com.dw.jdbcapp.repository.iface.OrderRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderJdbcRepository implements OrderRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "select * from 주문";
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("데이터베이스 연결 성공");
            while (resultSet.next()) {
                Order order = new Order();

                order.setOrderId(resultSet.getString("주문번호"));
                order.setCustomerId(resultSet.getString("고객번호"));
                order.setEmployeeId(resultSet.getString("사원번호"));
                order.setOrderDate(LocalDate.parse(resultSet.getString("주문일")));
                order.setRequestDate(LocalDate.parse(resultSet.getString("요청일")));
                order.setShippingDate(LocalDate.parse(resultSet.getString("발송일")));
                orders.add(order);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order getOrderById(String id) {


        Order order = new Order();

        String query = "select * from 주문 where 주문번호 = ?";

        try (Connection connection = DriverManager.getConnection(
                URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            System.out.println("데이터베이스 연결 성공");
            pstmt.setString(1, id);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {


                    order.setOrderId(resultSet.getString("주문번호"));
                    order.setCustomerId(resultSet.getString("고객번호"));
                    order.setEmployeeId(resultSet.getString("사원번호"));
                    order.setOrderDate(LocalDate.parse(resultSet.getString("주문일")));
                    order.setRequestDate(LocalDate.parse(resultSet.getString("요청일")));
                    order.setShippingDate(LocalDate.parse(resultSet.getString("발송일")));

                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
    @Override
    public Order getOrderById_2(String number,String id ) {


        Order order = new Order();

        String query = "select * from 주문 "
                + "inner join 주문세부 on 주문.주문번호 = 주문세부.주문번호 "+
                " inner join 제품 on 제품.제품번호 = 주문세부.제품번호 " +

                " where 제품.제품번호 = ? and 주문.고객번호 = ? ";

        try (Connection connection = DriverManager.getConnection(
                URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            System.out.println("데이터베이스 연결 성공");
            pstmt.setString(1, number);
            pstmt.setString(2,id);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {


                    order.setOrderId(resultSet.getString("주문번호"));
                    order.setCustomerId(resultSet.getString("고객번호"));
                    order.setEmployeeId(resultSet.getString("사원번호"));
                    order.setOrderDate(LocalDate.parse(resultSet.getString("주문일")));
                    order.setRequestDate(LocalDate.parse(resultSet.getString("요청일")));
                    order.setShippingDate(LocalDate.parse(resultSet.getString("발송일")));

                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
}
