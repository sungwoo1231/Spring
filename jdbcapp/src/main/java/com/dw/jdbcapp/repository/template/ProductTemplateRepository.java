package com.dw.jdbcapp.repository.template;

import com.dw.jdbcapp.dto.ProductDTO;
import com.dw.jdbcapp.exception.ResourceNotFoundException;
import com.dw.jdbcapp.model.Product;
import com.dw.jdbcapp.repository.iface.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductTemplateRepository implements ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;


    // RowMapper
    private final RowMapper<Product> productRowMapper = new RowMapper<Product>() {
        @Override
        //ResulSet rs = 1개의 행, int rowNum = 열의 갯수
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException { // throws = try catch 역할
            Product product = new Product();
            product.setProductNumber(rs.getInt("제품번호"));
            product.setProductName(rs.getString("제품명"));
            product.setPackagingUnit(rs.getString("포장단위"));
            product.setUnitPrice(rs.getDouble("단가"));
            product.setStock(rs.getInt("재고"));
            return product;
        }
    };


    @Override
    public List<Product> getAllProducts() {
        String query = "select * from 제품";
        return jdbcTemplate.query(query, productRowMapper);
    }

    @Override
    // 단일 행이라 queryForObject를 사용
    public Product getProductById(int id) {
        String query = "select * from 제품 where 제품번호 = ?";
        try {
            return jdbcTemplate.queryForObject(query, productRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            // 자바에 정의된 예외를 사용자정의예외로 바꿈으로 인해
            // CustomExceptionHandler의 코드를 단순하게 유지 가능
            // (예외들을 비슷한 유형으로 그룹 지을 수 있음)
            throw new ResourceNotFoundException(
                    "제품번호가 올바르지 않습니다:" + id);
        }
    }

    @Override
    // Post(insert)
    public Product saveProduct(Product product) {
        String query = "insert into 제품(제품번호,제품명,포장단위,단가,재고) "
                + "values (?, ?, ?, ?, ?) ";
        jdbcTemplate.update(query,
                product.getProductNumber(),
                product.getProductName(),
                product.getPackagingUnit(),
                product.getUnitPrice(),
                product.getStock());
        return product;
    }

    @Override
    // Put (update)
    public Product updateProduct(Product product) {
        String query = "update 제품 set 포장단위 = ? , 단가 = ?, 재고 = ? where 제품번호 = ?";
        jdbcTemplate.update(query,
                product.getPackagingUnit(),
                product.getUnitPrice(),
                product.getStock(),
                product.getProductNumber());
        return product;
    }

    @Override
    // Delete
    public String deleteProduct(String id) {
        String query = "delete from 제품 where 제품번호 = ? ";
        jdbcTemplate.update(query,id);
        return id;
    }

    @Override
    public String updateProductWithStock(int id, int stock) {
        String query = "update 제품 set 재고 =? where 제품번호=? ";
        jdbcTemplate.update(query, stock , id);
        return "성공";

    }

    @Override
    public List<Product> getProductByProductName(String name) {
        String query = "select * from 제품 where 제품명 like ? ";
        String name1 = "%" + name + " %" ;

        return jdbcTemplate.query(query,productRowMapper,name1);


    }

    @Override
    public List<Product> getProductsByStockValue() {
        String query = "select 제품번호,제품명,단가,재고, sum(단가*재고) as 재고금액 from 제품 " +
                        "group by 제품번호, 제품명 ,단가 ,재고 " ;
        return jdbcTemplate.query(query,productRowMapper);
    }


}
