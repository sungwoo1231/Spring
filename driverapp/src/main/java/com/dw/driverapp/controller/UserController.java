
package com.dw.driverapp.controller;

import com.dw.driverapp.dto.UserDTO;
import com.dw.driverapp.exception.ResourceNotFoundException;
import com.dw.driverapp.exception.UnauthorizedUserException;
import com.dw.driverapp.model.User;
import com.dw.driverapp.repository.AuthorityRepository;
import com.dw.driverapp.repository.UserRepository;
import com.dw.driverapp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;



    // 유저 - 회원가입
    @PostMapping("/user/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.registerUser(userDTO), HttpStatus.CREATED);
    }

    // 관리자 - 모든 회원정보 조회
    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAllUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            throw new UnauthorizedUserException("로그인한 사용자만 게시글 조회가 가능합니다.");
        }
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping("/user/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO, HttpServletRequest request) {
        String username = userDTO.getUserName();
        String password = userDTO.getPassword();

        if (userService.validateUser(username, password)) {
            // 로그인된 유저 정보 가져오기
            User user = userRepository.findById(username)
                    .orElseThrow(() -> new ResourceNotFoundException("사용자가 존재하지 않습니다."));

            // 세션에 유저 권한 저장
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", user.getAuthority().getAuthorityName()); // 권한도 함께 저장

            return new ResponseEntity<>("로그인이 완료되었습니다.", HttpStatus.OK);
        } else {
            throw new UnauthorizedUserException("입력하신 정보가 올바르지 않습니다.");
        }
    }

    // 유저 - 로그아웃
    @PostMapping("/user/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return new ResponseEntity<>(
                "로그아웃 되었습니다.",
                HttpStatus.OK);
    }

    @GetMapping("/user/username/{username}")
    public ResponseEntity<User> usernameFind(@PathVariable String username, HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            throw new UnauthorizedUserException("로그인한 사용자만 게시글 조회가 가능합니다.");
        }

        // 세션에서 로그인된 유저 정보와 권한 정보 가져오기
        String loggedInUser = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");

        // 자기 자신 정보 조회는 허용
        if (!loggedInUser.equals(username) && !"ADMIN".equals(role)) {
            throw new UnauthorizedUserException("자기 자신만 조회할 수 있습니다.");
        }

        // 유저 정보 조회
        return new ResponseEntity<>(userService.usernameFind(username), HttpStatus.OK);
    }


    // 유저- email로 정보 조회
    @GetMapping("/user/email/{email}")
    public ResponseEntity<User> userEmailFind(@PathVariable String email,HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            throw new UnauthorizedUserException("로그인한 사용자만 게시글 조회가 가능합니다.");
        }
        return new ResponseEntity<>(userService.userEmailFind(email), HttpStatus.OK);
    }

    // 유저-realname으로 정보 조회
    @GetMapping("/user/realname/{realname}")
    public ResponseEntity<List<User>> realNameFind(@PathVariable String realname,HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            throw new UnauthorizedUserException("로그인한 사용자만 게시글 조회가 가능합니다.");
        }
        return new ResponseEntity<>(userService.realNameFind(realname), HttpStatus.OK);


    }

    // 유저-birthdate로 정보 조회
    @GetMapping("/user/birthdate/{birthdate}")
    public ResponseEntity<List<User>> userBirthdateFind(@PathVariable LocalDate birthdate,HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            throw new UnauthorizedUserException("로그인한 사용자만 게시글 조회가 가능합니다.");
        }
        return new ResponseEntity<>(userService.userBirthdateFind(birthdate), HttpStatus.OK);
    }

    // 관리자- 권한으로 정보 조회*****
    @GetMapping("/user/authority/{authority}")
    public ResponseEntity<List<User>> userauthorityFind(@PathVariable String authority,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            throw new UnauthorizedUserException("로그인한 사용자만 게시글 조회가 가능합니다.");
        }

        return new ResponseEntity<>(userService.userauthorityFind(authority),HttpStatus.OK);
    }

    // 유저- 지정된 날짜 이후 가입자 정보 조회
    @GetMapping("/user/over/{date}")
    public ResponseEntity<List<User>> userdateoverFind(@PathVariable LocalDate date,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            throw new UnauthorizedUserException("로그인한 사용자만 게시글 조회가 가능합니다.");
        }
        return new ResponseEntity<>(userService.userdateoverFind(date),HttpStatus.OK);
    }

    // 유저- 지정된 날짜 이전 가입자 정보 조회
    @GetMapping("/user/under/{date}")
    public ResponseEntity<List<User>> userdateunderFind(@PathVariable LocalDate date,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            throw new UnauthorizedUserException("로그인한 사용자만 게시글 조회가 가능합니다.");
        }
        return new ResponseEntity<>(userService.userdateunderFind(date),HttpStatus.OK);
    }


    // 유저- 지정된 날짜 가입자 정보 조회
    @GetMapping("/user/date/{date}")
    public ResponseEntity<List<User>> userdateFind(@PathVariable LocalDate date,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            throw new UnauthorizedUserException("로그인한 사용자만 게시글 조회가 가능합니다.");
        }
        return new ResponseEntity<>(userService.userdateFind(date),HttpStatus.OK);
    }

    //유저- 지정된 날짜 사이에 가입한 정보 조회
    @GetMapping("/user/{date1}/{date2}")
    public ResponseEntity<List<User>> userbetweenFind(@PathVariable LocalDate date1,@PathVariable LocalDate date2,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            throw new UnauthorizedUserException("로그인한 사용자만 게시글 조회가 가능합니다.");
        }
        return new ResponseEntity<>(userService.userbetweenFind(date1,date2),HttpStatus.OK);
    }

    // 유저 - 비밀번호 변경
    @PutMapping("/user/update/password")
    public ResponseEntity<User> userUpdatePassWord(@RequestBody User user,HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            throw new UnauthorizedUserException("로그인한 사용자만 비밀번호 변경이 가능합니다.");
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return new ResponseEntity<>(userService.userUpdatePassWord(user),HttpStatus.OK);
    }

    // 유저 - 회원탈퇴
    @DeleteMapping("/user/delete")
    public ResponseEntity<String> deleteUser(HttpServletRequest request) {
        // 로그인한 사람만 탈퇴 가능 코드
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            throw new UnauthorizedUserException("로그인한 사용자만 회원 탈퇴가 가능합니다.");
        }
        String username = (String) session.getAttribute("username");

        userService.deleteUser(username);

        session.invalidate();

        return new ResponseEntity<>("회원 탈퇴가 완료되었습니다.", HttpStatus.OK);
    }
}
