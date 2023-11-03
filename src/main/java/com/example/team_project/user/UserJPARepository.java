package com.example.team_project.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserJPARepository extends JpaRepository<User, Integer> {

    @Query(value = "select u from User u where u.username = :username")
    User findByUsername(@Param("username") String username);

    @Query(value = "select u from User u where u.id = :id")
    User findByUserId(@Param("id") String id);

    @Modifying
    @Query("UPDATE User u SET u.username = :username, u.password = :password , u.nickname = :nickname WHERE u.id = :userId")
    void mUpdateUser(@Param("userId") Integer userId, @Param("username") String username,
            @Param("password") String password, @Param("nickname") String nickname);

}
