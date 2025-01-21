
package com.dw.driverapp.controller;

import com.dw.driverapp.dto.SubjectDTO;
import com.dw.driverapp.exception.UnauthorizedUserException;
import com.dw.driverapp.model.Subject;
import com.dw.driverapp.service.SubjectService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSInput;

import java.lang.invoke.CallSite;
import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    // 유저- 과목 전체를 조회
    @GetMapping("/subject/all")
    public ResponseEntity<List<SubjectDTO>> getAllSubject() {
        return new ResponseEntity<>(subjectService.getAllSubject(), HttpStatus.OK);
    }

    // 유저- 과목을 id로 조회
    @GetMapping("/subject/{id}")
    public ResponseEntity<SubjectDTO> subjectIdfind(@PathVariable Long id) {
        return new ResponseEntity<>(subjectService.subjectIdfind(id), HttpStatus.OK);
    }

    @PostMapping("/subject/add")
    public ResponseEntity<SubjectDTO> subjectAdd(@RequestBody SubjectDTO subjectDTO, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            throw new UnauthorizedUserException("로그인한 사용자만 강의를 생성할 수 있습니다.");
        }

        String role = (String) session.getAttribute("role");
        String username = (String) session.getAttribute("username");


        if (!"ADMIN".equals(role) && !"INSTRUCTOR".equals(role)) {
            throw new UnauthorizedUserException("관리자와 강사만 강의를 생성할 수 있습니다.");
        }

        // 강사의 경우 세션에서 가져온 username을 사용하여 강의 생성
        return new ResponseEntity<>(subjectService.subjectAdd(subjectDTO, username), HttpStatus.CREATED);
    }
}
