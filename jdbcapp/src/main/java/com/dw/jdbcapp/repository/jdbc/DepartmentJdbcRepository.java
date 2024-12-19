package com.dw.jdbcapp.repository.jdbc;

import com.dw.jdbcapp.model.Department;
import com.dw.jdbcapp.repository.iface.DepartmentRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentJdbcRepository implements DepartmentRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        String query = "select * from 부서";
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("데이터베이스 연결 성공");
            while (resultSet.next()) {
                Department department = new Department();

                department.setDepartmentNumber(resultSet.getString("부서번호"));
                department.setDepartmentName(resultSet.getString("부서명"));

                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }


    // Post(insert)
    @Override
    public Department saveDepartment(Department department) {

        String query = "insert into 부서(부서번호,부서명) "
                + "values (?, ?) "; // ? 자리에 매개변수를 넣을 예정
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, department.getDepartmentNumber());
            pstmt.setString(2, department.getDepartmentName());

            pstmt.executeUpdate();
            System.out.println("INSERT 성공");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 매개변수로 전달받은 Department 객체 정보를 MySQL에 insert 후
        // 성공이면 해당 객체를 리턴함
        return department;
    }

    // Put (Update)
    @Override
    public Department updateDepartment(Department department) {
        String query = "update 부서 set 부서명 = ? where 부서번호 = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, department.getDepartmentName());
            pstmt.setString(2, department.getDepartmentNumber());
            pstmt.executeUpdate();
            System.out.println("Update 성공");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public String deleteDepartment(String id) {
        String query = "delete from 부서 where 부서번호 = ? ";
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


}