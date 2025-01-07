package dw.com.companyapp.repository;

import dw.com.companyapp.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderRepository extends JpaRepository<Order,String> {
@Query("select o from Order o where o.customer.id = :customerId and o.orderId " +
        "in (select orderId from OrderDetail od where od.product.Id =:productNumber )")
    List<Order> findByProductNumberPosition(int productNumber, String customerId);


    @Query(value = " select year (주문일) as 주문년도, count(주문번호) as 주문건수\n " +
            " from 주문\n " +
            " where 고객번호 in (select 고객번호 from 고객 where 고객.도시 = ? )\n " +
            " group by 주문년도 ",nativeQuery = true )
    List<Map<String,Double>> getOrderCountByYearForCity(String city);
    // DTO를 만들어 사용하는 방식 JPQL
    // @Query("select new com.dw.companyapp.dto.CityOrderAmountDTO(c.city, " +
    //            "sum(od.unitPrice * od.orderQuantity) as orderAmount) " +
    //            "from OrderDetail od join od.order.customer c " +
    //            "group by c.city order by orderAmount desc limit :limit")
    //    List<CityOrderAmountDTO> getTopCitiesByTotalOrderAmount(int limit);


    @Query(value = "select 도시, sum(단가*주문수량) as 주문금액합 " +
            "from 주문 " +
            " inner join 고객 " +
            "on 주문.고객번호 = 고객.고객번호 " +
            " inner join 주문세부 " +
            " on 주문.주문번호 = 주문세부.주문번호 " +
            " group by 도시 " +
            " order by 주문금액합 desc " +
            " limit  ? ",nativeQuery = true)
    List<Map<String,Double>> getTopCitiesByTotalOrderAmount(int limit);
    // DTO를 만들어 사용하는 방식 JPQL
    //@Query("select new com.dw.companyapp.dto.YearOrderCountDTO(year(o.orderDate), count(o.orderId)) " +
    //            "from Order o join o.customer c " +
    //            "where c.city = :city group by year(o.orderDate)")
    //    List<YearOrderCountDTO> getOrderCountByYearForCity(String city);
}
