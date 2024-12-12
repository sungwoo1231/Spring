package com.dw.jdbcapp.repository;

import com.dw.jdbcapp.model.MileGrade;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MileGradeRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public List<MileGrade> getAllMileGrades(){
        List<MileGrade> mileGrades = new ArrayList<>();
        String query = "select * from 마일리지등급";
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("데이터베이스 연결 성공");
            while (resultSet.next()) {
                MileGrade mileGrade = new MileGrade();

                mileGrade.setGradeName(resultSet.getString("등급명"));
                mileGrade.setLowerMileage(resultSet.getInt("하한마일리지"));
                mileGrade.setUpperMileage(resultSet.getInt("상한마일리지"));
                mileGrades.add(mileGrade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mileGrades;
    }
}
