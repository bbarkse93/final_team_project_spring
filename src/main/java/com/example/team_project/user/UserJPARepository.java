package com.example.team_project.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserJPARepository extends JpaRepository<User, Integer> {

    @Query(value = "select u from User u where u.username = :username")
    User findByUsername(@Param("username") String username);


}
