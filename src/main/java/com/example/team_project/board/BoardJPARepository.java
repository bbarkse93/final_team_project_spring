package com.example.team_project.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import java.util.List;

import com.example.team_project.board.board_pic.BoardPic;

public interface BoardJPARepository extends JpaRepository<Board, Integer> {

    @Query("select p from BoardPic p where p.board.id = :id")
    List<BoardPic> findByBoardId(@Param("id") Integer id);

    @Query(value = "SELECT b, c, p , u FROM Board b INNER JOIN b.boardCategory c LEFT JOIN b.boardPics p INNER JOIN b.user u")
    List<Board> mFindAllJoinBoardCategoryAndBoardPic();

    @Modifying
    @Query("UPDATE Board b SET b.boardContent = :boardContent, b.boardTitle = :boardTitle WHERE b.id = :boardId")
    int updateBoard(@Param("boardId") int boardId, @Param("boardContent") String boardContent, @Param("boardTitle") String boardTitle);
}
