package com.example.team_project.board.board_pic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BoardPicJPARepository extends JpaRepository<BoardPic, Integer> {

    List<BoardPic> findByBoardId(Integer boardId);

    @Modifying
    @Query("UPDATE BoardPic b SET b.boardPicUrl = :boardPicUrl WHERE b.board.id = :id")
    int updateBoardPic(@Param("id") int id, @Param("boardPicUrl") String boardPicUrl);
}
