package com.dw.driverapp.repository;

import com.dw.driverapp.dto.BoardAllDTO;
import com.dw.driverapp.dto.BoardDTO;
import com.dw.driverapp.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Long> {
    Optional<List<Board>> findByTitleLike(String title);
    Optional<List<Board>> findByAuthor_UserName(String username);

    @Query(value = "SELECT * FROM 게시판 b ORDER BY b.created_date DESC LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Board> findBoardsByRecentOrder(@Param("limit") int limit, @Param("offset") int offset);

}
