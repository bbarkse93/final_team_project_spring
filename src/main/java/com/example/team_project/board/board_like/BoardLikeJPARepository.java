package com.example.team_project.board.board_like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardLikeJPARepository extends JpaRepository<BoardLike, Integer> {

    @Modifying
    @Query(value = "INSERT INTO board_like_tb (`id`, `board_id`,`user_id`) VALUES (:Id, :boardId,:userId)", nativeQuery = true)
    int mSave(@Param("Id") Integer Id, @Param("boardId") Integer boardId, @Param("userId") Integer userId);

}
