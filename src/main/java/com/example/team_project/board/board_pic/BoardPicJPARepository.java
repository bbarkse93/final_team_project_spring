package com.example.team_project.board.board_pic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardPicJPARepository extends JpaRepository<BoardPic, Integer> {

    List<BoardPic> findByBoardId(Integer boardId);

    @Modifying
    @Query(value = "INSERT INTO board_pic_tb (`board_pic_url`, `board_id`) VALUES (:boardPicUrl, :boardId)", nativeQuery = true)
    int mSave(@Param("boardPicUrl") String boardPicUrl, @Param("boardId") Integer boardId);

    @Modifying
    @Query("UPDATE BoardPic b SET b.boardPicUrl = :boardPicUrl WHERE b.id = :id")
    int updateBoardPic(@Param("id") int id, @Param("boardPicUrl") String boardPicUrl);
}
