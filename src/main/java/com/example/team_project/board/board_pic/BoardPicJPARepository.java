package com.example.team_project.board.board_pic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardPicJPARepository extends JpaRepository<BoardPic, Integer> {

    List<BoardPic> findByBoardId(Integer boardId);
}
