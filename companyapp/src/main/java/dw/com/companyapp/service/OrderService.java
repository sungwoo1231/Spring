package dw.com.companyapp.service;


import dw.com.companyapp.dto.OrderRequestDTO;
import dw.com.companyapp.exception.InvalidRequestException;
import dw.com.companyapp.exception.ResourceNotFoundException;
import dw.com.companyapp.model.Department;
import dw.com.companyapp.model.Order;
import dw.com.companyapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // 과제 1-2 주문번호를 기준으로 주문 정보를 조회하는 API
    // 과제 3-2 주문정보를 조회할때 주문번호가 올바르지 않은 경우의 예외 처리
    public Order getOrderById(String orderNumber) {
       return orderRepository.findById(orderNumber).orElseThrow(()-> new InvalidRequestException("사원정보가 올바르지 않습니다."));

    }

    // 과제 1-4 제품번호와 고객번호를 기준으로 해당 제품을 주문한 특정 고객의 주문 내역을 조회하는 API
    // 과제 3-4 제품번호와 고객번호로 주문정보를 조회할때 데이터가 없는 경우의 예외처리
    public List<Order> getOrderByIdAndCustomer(int productNumber, String customerId) {
        List<Order> orders = orderRepository.findByProductNumberPosition(productNumber,customerId).stream().toList();
        if (orders.isEmpty()){
            throw new ResourceNotFoundException("제품번호가 올바르지 않습니다.");
        }
        return orders;
    }

    public OrderRequestDTO saveOrder(OrderRequestDTO orderRequestDTO) {
        OrderRequestDTO orderRequestDTO1 = new OrderRequestDTO();
        orderRequestDTO1.setOrderId(orderRequestDTO.getOrderId());
        orderRequestDTO1.setOrderDetails(orderRequestDTO.getOrderDetails());
        orderRequestDTO1.setEmployeeId(orderRequestDTO.getEmployeeId());
        orderRequestDTO1.setRequestDate(orderRequestDTO.getRequestDate());
        orderRequestDTO1.setOrderDetails(orderRequestDTO.getOrderDetails());
        orderRequestDTO1.setShippingDate(orderRequestDTO.getShippingDate());


        return orderRequestDTO1;
    }

    // 과제 4-4 주문번호와 발송일을 매개변수로 해당 주문의 발송일을 수정하는 API
    public String updateOrderWithShippingDate(String id, String date) {

        Order order= orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        order.setShippingDate(LocalDate.parse(date));
        orderRepository.save(order);

        return "성공";

    }

    // 과제 4-5 도시별로 주문금액합 결과를 내림차순 정렬하여 조회하는 API
    public List<Map<String, Double>> getTopCitiesByTotalOrderAmount(int limit) {
        return orderRepository.getTopCitiesByTotalOrderAmount(limit).stream().toList();
    }

    // 과제 4-6 도시를 매개변수로 해당 도시의 년도별 주문건수를 조회하는 API
    public List<Map<String, Double>> getOrderCountByYearForCity(String city) {
        return orderRepository.getOrderCountByYearForCity(city).stream().toList();
    }
}
