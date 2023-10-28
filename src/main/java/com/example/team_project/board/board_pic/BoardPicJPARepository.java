package com.example.team_project.board.board_pic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BoardPicJPARepository extends JpaRepository<BoardPic, Integer> {

    List<BoardPic> findByBoardId(Integer boardId);
}
