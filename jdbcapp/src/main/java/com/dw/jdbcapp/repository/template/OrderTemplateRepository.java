package com.dw.jdbcapp.repository.template;

import com.dw.jdbcapp.exception.ResourceNotFoundException;
import com.dw.jdbcapp.model.Order;
import com.dw.jdbcapp.repository.iface.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderTemplateRepository implements OrderRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final RowMapper<Order> orderRowMapper = new RowMapper<Order>() {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();

            order.setOrderId(rs.getString("주문번호"));
            order.setCustomerId(rs.getString("고객번호"));
            order.setEmployeeId(rs.getString("사원번호"));
            order.setOrderDate(LocalDate.parse(rs.getString("주문일")));
            order.setRequestDate(LocalDate.parse(rs.getString("요청일")));
            order.setShippingDate(LocalDate.parse(rs.getString("발송일")));
            return order;
        }
    };


    @Override
    public List<Order> getAllOrders() {
        String query = "select * from 주문 ";
        return jdbcTemplate.query(query, orderRowMapper);
    }

    @Override
    public Order getOrderById(String id) {
        String query = "select * from 주문 where 주문번호 = ?";
        try {
            return jdbcTemplate.queryForObject(query, orderRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(
                    "주문번호가 올바르지 않습니다." + id);
        }
    }

    @Override
    public List<Order> getOrderById_2(int number, String id) {
        String query = "select * from 주문 where 고객번호 = ? and 주문번호 " +
                "in (select 주문번호 from 주문세부 where 제품번호 = ?)";
        try {
            return jdbcTemplate.query(query, orderRowMapper, number, id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(
                    "입력하신 제품번호와 고객번호가 올바르지 않습니다 " + number + " " + id);
        }
    }

    @Override
    public int saveOrder(Order order) {
        String query = "insert into 주문(주문번호,고객번호,사원번호,주문일,요청일)" +
                "values(?,?,?,?,?)";
        return jdbcTemplate.update(query,
                order.getOrderId(),
                order.getCustomerId(),
                order.getEmployeeId(),
                order.getOrderDate().toString(),
                order.getRequestDate().toString());
    }

    @Override
    public String updateOrderWithShippingDate(String id, String date) {
        String query = "update 주문 set 발송일 =? where 주문번호=? ";
        jdbcTemplate.update(query, date, id);
        return date;
    }

    @Override
    public List<Map<String, Double>> getTopCitiesByTotalOrderAmount(int limit) {
        String query = "select 도시, sum(단가*주문수량) as 주문금액합 " +
                "from 주문 " +
                " inner join 고객 " +
                "on 주문.고객번호 = 고객.고객번호 " +
                " inner join 주문세부 " +
                " on 주문.주문번호 = 주문세부.주문번호 " +
                " group by 도시 " +
                " order by 주문금액합 desc " +
                " limit  ? ";

        return jdbcTemplate.query(query, (rs, rowNum) -> {
            Map<String, Double> map = new HashMap<>();

           map.put(rs.getString("도시"),
                   rs.getDouble("주문금액합"));
            return map;
        }, limit);
    }

    private final RowMapper<Map<String, Double>> orderRowMapper1 = new RowMapper<Map<String, Double>>() {
        @Override
        public Map<String, Double> mapRow(ResultSet rs, int rowNum) throws SQLException {
            Map<String, Double> map = new HashMap<>();
            map.put(rs.getString("주문년도"), rs.getDouble("주문건수"));
            return map;
        }
    };

    @Override
    public List<Map<String,Double>> getOrderCountByYearForCity(String city){
        String query = " select year (주문일) as 주문년도, count(주문번호) as 주문건수\n " +
                " from 주문\n " +
                " where 고객번호 in (select 고객번호 from 고객 where 고객.도시 = ? )\n " +
                " group by 주문년도 " ;
        return jdbcTemplate.query(query,orderRowMapper1,city);
}

}