package com.dw.jdbcapp.repository.jdbc;

import com.dw.jdbcapp.dto.ProductDTO;
import com.dw.jdbcapp.model.Product;
import com.dw.jdbcapp.repository.iface.ProductRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductJdbcRepository implements ProductRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Override
    public List<Product> getAllProducts() {
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

    @Override
    public Product getProductById(int id) {

        Product product = new Product();

        String query = "select * from 제품 where 제품번호 = ?";

        try (Connection connection = DriverManager.getConnection(
                URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            System.out.println("데이터베이스 연결 성공");
            pstmt.setInt(1, id);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {


                    product.setProductNumber(resultSet.getInt("제품번호"));
                    product.setProductName(resultSet.getString("제품명"));
                    product.setPackagingUnit(resultSet.getString("포장단위"));
                    product.setUnitPrice(resultSet.getDouble("단가"));
                    product.setStock(resultSet.getInt("재고"));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    // Post(insert)
    @Override
    public Product saveProduct(Product product) {
        String query = "insert into 제품(제품번호,제품명,포장단위,단가,재고) "
                + "values (?, ?, ?, ?, ?) ";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, product.getProductNumber());
            pstmt.setString(2, product.getProductName());
            pstmt.setString(3, product.getPackagingUnit());
            pstmt.setDouble(4, product.getUnitPrice());
            pstmt.setInt(5, product.getStock());
            pstmt.executeUpdate();
            System.out.println("INSERT 성공");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 매개변수로 전달받은 Department 객체 정보를 MySQL에 insert 후
        // 성공이면 해당 객체를 리턴함
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        String query = "update 제품 set 포장단위 = ? , 단가 = ?, 재고 = ? where 제품번호 = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, product.getPackagingUnit());
            pstmt.setDouble(2,product.getUnitPrice());
            pstmt.setInt(3,product.getStock());
            pstmt.setInt(4, product.getProductNumber());
            pstmt.executeUpdate();
            System.out.println("Update 성공");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;

    }
    // Delete
    @Override
    public String deleteProduct(String id) {
        String query = "delete from 제품 where 제품번호 = ? ";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1,id);
            pstmt.executeUpdate();
            System.out.println("Delete 성공: " + id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public String updateProductWithStock(int id, int stock) {
        return "";
    }

    @Override
    public List<Product> getProductByProductName(String name) {

        return List.of();
    }

    @Override
    public List<Product> getProductsByStockValue() {
        return List.of();
    }



}
