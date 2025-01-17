package com.dw.driverapp.controller;

import com.dw.driverapp.dto.CartDTO;
import com.dw.driverapp.exception.ResourceNotFoundException;
import com.dw.driverapp.exception.UnauthorizedUserException;
import com.dw.driverapp.repository.CartRepository;
import com.dw.driverapp.service.CartService;
import com.dw.driverapp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
 @Autowired
    CartService cartService;

    // 유저 -> 모든 장바구니 목록 조회
    @GetMapping("/cart/all")
    public ResponseEntity<List<CartDTO>> getAllCart(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            throw new ResourceNotFoundException("로그인한 사용자만 장바구니 조회가 가능합니다.");
        }
        return new ResponseEntity<>(cartService.getAllCart(), HttpStatus.OK);
    }
    // 유저 -> 특정 유저 장부구니 조회
    @GetMapping("/cart/user/{username}")
    private ResponseEntity<List<CartDTO>> findUserName(@PathVariable String username,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            throw new ResourceNotFoundException("로그인한 사용자만 장바구니 조회가 가능합니다.");
        }
        return new ResponseEntity<>(cartService.findUserName(username),HttpStatus.OK);
    }
}
