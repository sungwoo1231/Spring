package com.dw.jdbcapp.repository;

import com.dw.jdbcapp.model.OrderDetail;
import com.dw.jdbcapp.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        String query = "select * from 제품";
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("데이터베이스 연결 성공");
            while (resultSet.next()) {
                Product product = new Product();

              product.setProductNumber(resultSet.getInt("제품번호"));
              product.setProductName(resultSet.getString("제품명"));
              product.setPackagingUnit(resultSet.getString("포장단위"));
              product.setUnitPrice(resultSet.getDouble("단가"));
              product.setStock(resultSet.getInt("재고"));
              products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    }

