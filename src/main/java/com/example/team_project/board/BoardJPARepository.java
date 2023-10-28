package com.example.team_project.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface BoardJPARepository extends JpaRepository<Board, Integer> {

    // @Query("select p from BoardPic p where p.board.id = :id")
    // List<BoardPic> findByBoardId(@Param("id") Integer id);

    @Query("select b from Board b where b.boardTitle = :boardTitle")
    Board findByBoardTitle(String boardTitle);

}
