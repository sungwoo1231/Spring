package com.dw.driverapp.service;

import com.dw.driverapp.dto.UserDTO;
import com.dw.driverapp.exception.InvalidRequestException;
import com.dw.driverapp.exception.ResourceNotFoundException;
import com.dw.driverapp.exception.UnauthorizedUserException;
import com.dw.driverapp.model.User;
import com.dw.driverapp.repository.AuthorityRepository;
import com.dw.driverapp.repository.SubjectRepository;
import com.dw.driverapp.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    AuthorityRepository authorityRepository;

    // 회원가입
    public UserDTO registerUser(UserDTO userDTO) {
        Optional<User> user = userRepository.findById(userDTO.getUserName());
        if (user.isPresent()) {
            throw new InvalidRequestException("입력하신 정보가 이미 존재합니다.");
        }
        return userRepository.save(
                new User(
                        userDTO.getUserName(),
                        passwordEncoder.encode(userDTO.getPassword()),
                        userDTO.getEmail(),
                        userDTO.getRealName(),
                        userDTO.getBirthdate(),
                        authorityRepository.findById("User")
                                .orElseThrow(() -> new ResourceNotFoundException("권한 없음")),
                        LocalDateTime.now(),
                        10000)

        ).toDTO(); // 회원가입
    }
    // 모든 회원 정보조회
    public List<User> getAllUser() {
        return userRepository.findAll(); // 회원정보 조회
    }

    // 로그인 , 로그아웃
    public boolean validateUser(String username, String password) {
        User user = userRepository.findById(username)
                .orElseThrow(()->new InvalidRequestException("사용자의 이름이 잘못되었습니다."));
        return passwordEncoder.matches(password, user.getPassword());
    }
    // 로그인 중인 유저 확인
    public User getCurrentByUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new UnauthorizedUserException("사용자가 없습니다.");
        }
        String userName = (String) session.getAttribute("username");
        return userRepository.findById(userName)
                .orElseThrow(()->new InvalidRequestException("No username"));
    }
    public User get(String username) {
        return userRepository.findById(username).orElseThrow(()->new ResourceNotFoundException("존재하지 않는 username입니다."));
    }

    public List<User> realName(String realname) {
        List<User> userList = new ArrayList<>();
        userRepository.findByRealName(realname).stream().toList();
        if (userList.isEmpty()){
            throw new ResourceNotFoundException("존재하지 않습니다");
        }
        return userList;
    }


}


