package com.dw.driverapp.service;

import com.dw.driverapp.dto.CartDTO;
import com.dw.driverapp.dto.EnrollmentDTO;
import com.dw.driverapp.exception.InsufficientFundsException;
import com.dw.driverapp.exception.ResourceNotFoundException;
import com.dw.driverapp.exception.UnauthorizedUserException;
import com.dw.driverapp.model.Cart;
import com.dw.driverapp.model.Enrollment;
import com.dw.driverapp.model.Subject;
import com.dw.driverapp.model.User;
import com.dw.driverapp.repository.CartRepository;
import com.dw.driverapp.repository.EnrollmentRepository;
import com.dw.driverapp.repository.SubjectRepository;
import com.dw.driverapp.repository.UserRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    EnrollmentRepository enrollmentRepository;


    // 유저 -> 모든 장바구니 목록 조회
    public List<CartDTO> getAllCart() {
        return cartRepository.findAll().stream().map(Cart::ToDto).toList();
    }

    // 유저 -> 특정 유저 장부구니 조회
    public List<CartDTO> findUserName(String username) {
        return cartRepository.findByUserUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("없음"))
                .stream()
                .map(Cart::ToDto)
                .toList();
    }

    // 유저 - 로그인 중인 사용자의 이름으로 장바구니 추가
    public CartDTO addSubjectToCart(String username, Long subjectId) {
        User user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("해당 유저가 존재하지 않습니다."));
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("해당 과목이 존재하지 않습니다."));
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setSubject(subject);
        Cart savedCart = cartRepository.save(cart);
        return savedCart.ToDto();
    }

    // 여러 장바구니 항목을 삭제하는 서비스
    public void deleteCartItems(List<Long> cartIds, String username) {
        List<Cart> carts = cartRepository.findByUserUserNameAndIdIn(username, cartIds);

        if (carts.isEmpty()) {
            throw new ResourceNotFoundException("선택한 항목이 없습니다.");
        }

        for (Cart cart : carts) {
            if (!cart.getUser().getUserName().equals(username)) {
                throw new UnauthorizedUserException("해당 항목을 삭제할 수 없습니다.");
            }
            cartRepository.delete(cart);
        }
    }


    // 유저- 로그인한 회원의 장바구니에서 과목아이디로 구매(자동으로 유저의 포인트에서 과목의 가격을 계산)
    // 유저- 로그인한 회원의 장바구니에서 과목아이디로 구매(자동으로 유저의 포인트에서 과목의 가격을 계산)
    public void cartEnrollment(String username, List<Long> cartIds) {
        // 해당 사용자와 일치하는 장바구니 항목들을 여러 ID로 찾기
        List<Cart> cartList = cartRepository.findByUser_UserNameAndIdIn(username, cartIds);
        if (cartList.isEmpty()) {
            throw new ResourceNotFoundException("해당 과목들이 장바구니에 없습니다.");
        }

        // 사용자 정보를 조회
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("사용자를 찾을 수 없습니다."));
        int userPoint = user.getPoint();  // 사용자의 포인트 (최초 포인트)

        int totalPointsRequired = 0;  // 총 필요 포인트를 누적

        // 각 항목에 대해 구매 처리
        for (Cart cart : cartList) {
            Subject subject = cart.getSubject();
            int subjectPrice = (int) subject.getPrice();  // 과목 가격

            // 총 필요한 포인트를 누적
            totalPointsRequired += subjectPrice;
        }

        // 포인트가 부족한 경우 예외 처리
        if (userPoint < totalPointsRequired) {
            throw new InsufficientFundsException("포인트가 부족하여 결제할 수 없습니다.");
        }

        // 각 항목에 대해 포인트 차감 및 구매 처리
        for (Cart cart : cartList) {
            Subject subject = cart.getSubject();
            int subjectPrice = (int) subject.getPrice();  // 과목 가격

            // 포인트 차감
            user.setPoint(userPoint - subjectPrice);
            userRepository.save(user);

            // 구매 내역 저장
            Enrollment enrollment = new Enrollment();
            enrollment.setUser(cart.getUser());
            enrollment.setSubject(cart.getSubject());
            enrollment.setPurchaseTime(LocalDate.now());
            enrollmentRepository.save(enrollment);

            // 장바구니에서 해당 항목 삭제
            cartRepository.delete(cart);

            // 다음 항목을 위한 포인트 갱신
            userPoint -= subjectPrice; // 각 항목마다 차감한 후 남은 포인트 갱신
        }
    }


    public List<CartDTO> cartFindLoginUsername(String username) {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("존재하지 않는 유저입니다."));

        // 장바구니 항목을 유저 이름으로 조회
        List<Cart> carts = cartRepository.findByUser_UserName(username);

        // 장바구니가 비어 있으면 빈 리스트를 반환하거나 적절한 메시지 반환
        if (carts.isEmpty()) {
            return new ArrayList<>(); // 빈 장바구니일 때는 빈 리스트 반환
        }

        // 장바구니 항목들을 CartDTO로 변환하여 리스트로 반환
        return carts.stream()
                .map(Cart::ToDto)
                .collect(Collectors.toList());
    }
}







