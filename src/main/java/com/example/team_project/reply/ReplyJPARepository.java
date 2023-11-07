package com.example.team_project.reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyJPARepository extends JpaRepository<Reply, Integer> {
    @Query("select r from Reply r where r.user.id = :id")
    List<Reply> findbyUserId(Integer id);
}
