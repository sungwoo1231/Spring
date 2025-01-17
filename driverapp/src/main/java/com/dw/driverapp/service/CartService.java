package com.dw.driverapp.service;

import com.dw.driverapp.dto.CartDTO;
import com.dw.driverapp.exception.ResourceNotFoundException;
import com.dw.driverapp.model.Cart;
import com.dw.driverapp.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    // 유저 -> 모든 장바구니 목록 조회
    public List<CartDTO> getAllCart(){
        return cartRepository.findAll().stream().map(Cart::toDTO).toList();
    }
    // 유저 -> 특정 유저 장부구니 조회
    public List<CartDTO> findUserName(String username){
        return cartRepository.findByUserUserName(username).orElseThrow(()->new ResourceNotFoundException("없음"))
                .stream()
                .map(Cart::toDTO)
                .toList();
    }
}
