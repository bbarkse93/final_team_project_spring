package com.example.team_project.board.board_category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardCategoryJPARepository extends JpaRepository<BoardCategory, Integer> {
    
}
