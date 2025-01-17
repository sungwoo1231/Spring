package com.dw.driverapp.service;

import com.dw.driverapp.dto.CommentDTO;
import com.dw.driverapp.exception.ResourceNotFoundException;
import com.dw.driverapp.model.Comment;
import com.dw.driverapp.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    // 유저 -> 게시판에 달린 모든 유저 답글 조회
    public List<CommentDTO> getAllComment(){
        return commentRepository.findAll().stream().map(Comment::commentDTO).toList();
    }

    public List<CommentDTO> usernameFind(String username){
        return commentRepository.findByUserUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("해당 유저의 댓글이 없습니다."))
                .stream()
                .map(Comment::commentDTO)
                .toList();
    }
    public List<CommentDTO> boardIdFind(Long id){
        return commentRepository.findByBoardId(id)
                .filter(commentDTOS -> !commentDTOS.isEmpty())
                .orElseThrow(()-> new ResourceNotFoundException("없음"))
                .stream()
                .map(Comment::commentDTO)
                .collect(Collectors.toList());




    }

}
