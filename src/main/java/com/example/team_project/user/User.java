package com.example.team_project.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="user_tb")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false, unique = true)
    private String username; // 인증시 필요한 필드

    @Column(length = 256, nullable = false)
    private String password;

    private String email;

    private String userPicUrl;

    private String location;

    private Boolean distinguish;

    private Timestamp userCreatedAt;

    @Builder
    public User(Integer id, String username, String password, String email, String userPicUrl, String location, Boolean distinguish, Timestamp userCreatedAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userPicUrl = userPicUrl;
        this.location = location;
        this.distinguish = distinguish;
        this.userCreatedAt = userCreatedAt;
    }
}