
package com.dw.driverapp.controller;

import com.dw.driverapp.dto.BoardAllDTO;
import com.dw.driverapp.dto.BoardDTO;
import com.dw.driverapp.model.Board;
import com.dw.driverapp.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    // 유저- 게시판의 모든 글 조회
    @GetMapping("/board/all")
    public ResponseEntity<List<BoardAllDTO>> getAllBoard(){
        return new ResponseEntity<>(boardService.getAllBoard(),HttpStatus.OK);
    }

    // 유저- 게시판을 id로 조회(답글o)
    @GetMapping("/board/{id}")
    public ResponseEntity<BoardDTO> boardIdfind(@PathVariable Long id){
        return new ResponseEntity<>(boardService.boardIdfind(id),HttpStatus.OK);
    }

    //유저- 게시판의 제목을 검색해서 조회(답글o)
    @GetMapping("/board/title/search/{title}")
    public ResponseEntity<List<BoardDTO>> boardTitleFind(@PathVariable String title){
        return new ResponseEntity<>(boardService.boardTitleFind(title),HttpStatus.OK);
    }
    // 유저- 사용자의 게시한 게시글 조회
    @GetMapping("/boardusername/{username}")
    public ResponseEntity<List<BoardDTO>> boardUsernameFind (@PathVariable String username){
        return new ResponseEntity<>(boardService.boardUsernameFind(username),HttpStatus.OK);
    }

}
