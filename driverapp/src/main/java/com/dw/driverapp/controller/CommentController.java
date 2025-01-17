package com.dw.driverapp.controller;

import com.dw.driverapp.dto.CommentDTO;
import com.dw.driverapp.exception.UnauthorizedUserException;
import com.dw.driverapp.model.Board;
import com.dw.driverapp.model.Comment;
import com.dw.driverapp.model.User;
import com.dw.driverapp.service.CommentService;
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
public class CommentController {
    @Autowired
    CommentService commentService;

    // 유저 -> 게시판에 달린 모든 유저 답글 조회
    @GetMapping("/comment/all")
    public ResponseEntity<List<CommentDTO>> getAllComment(){
        return new ResponseEntity<>(commentService.getAllComment(), HttpStatus.OK);
    }
    @GetMapping("/comment/username/{username}")
    public ResponseEntity<List<CommentDTO>> usernameFind(@PathVariable String username, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            throw new UnauthorizedUserException("로그인한 사용자만 게시글 조회가 가능합니다.");
        }
        return new ResponseEntity<>(commentService.usernameFind(username), HttpStatus.OK);
    }
    @GetMapping("/comment/board/{id}")
    public ResponseEntity<List<CommentDTO>> boardIdFind(@PathVariable Long id){
        return new ResponseEntity<>(commentService.boardIdFind(id),HttpStatus.OK);
    }
}
