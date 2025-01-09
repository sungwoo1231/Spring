package com.dw.driverapp.service;

import com.dw.driverapp.dto.UserDTO;
import com.dw.driverapp.exception.InvalidRequestException;
import com.dw.driverapp.exception.ResourceNotFoundException;
import com.dw.driverapp.model.User;
import com.dw.driverapp.repository.AuthorityRepository;
import com.dw.driverapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;


    public UserDTO registerUser(UserDTO userDTO){
        Optional<User> user = userRepository.findById(userDTO.getUserName());
        if (user.isPresent()){
            throw new InvalidRequestException("");
        }
        return userRepository.save(
                new User(
                        userDTO.getUserName(),
                       passwordEncoder.encode(userDTO.getPassword()),
                        userDTO.getEmail(),
                        userDTO.getRealName(),
                        userDTO.getBirthdate(),
                        userDTO.getPoint(),
                        authorityRepository.findById("USER")
                                .orElseThrow(()-> new ResourceNotFoundException("")),
                        LocalDateTime.now())
                ).toDto();


    }

}
