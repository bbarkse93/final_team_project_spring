package com.example.team_project.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.example.team_project.board.board_pic.BoardPic;

public interface BoardJPARepository extends JpaRepository<Board, Integer> {

    @Query("select p from BoardPic p where p.board.id = :id")
    List<BoardPic> findByBoardId(@Param("id") Integer id);

}
