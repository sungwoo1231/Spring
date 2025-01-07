package dw.gameshop.controller;

import dw.gameshop.dto.BoardDTO;
import dw.gameshop.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/all")
    public ResponseEntity<List<BoardDTO>> getAllBoards() {
        return new ResponseEntity<>(
                boardService.getAllBoards(),
                HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<BoardDTO> saveBoard(@RequestBody BoardDTO boardDTO) {
        return new ResponseEntity<>(
                boardService.saveBoard(boardDTO),
                HttpStatus.CREATED);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable long id) {
        return new ResponseEntity<>(
                boardService.deleteBoard(id),
                HttpStatus.OK);
    }
}
