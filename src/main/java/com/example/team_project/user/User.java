package com.example.team_project.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import com.example.team_project.board.Board;
import com.example.team_project.board.board_like.BoardLike;
import com.example.team_project.board.board_pic.BoardPic;
import com.example.team_project.reply.Reply;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_tb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false, unique = true)
    private String username; // 인증시 필요한 필드

    @Column(length = 256, nullable = false)
    private String password;

    private String email;

    private String nickname;

    @Lob
    private String userPicUrl;

    private String location;

    private Boolean distinguish;

    @CreationTimestamp
    private Timestamp userCreatedAt;

    // @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    // private List<BoardPic> boardPics = new ArrayList<>();

    // @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    // private List<Board> boardwrites = new ArrayList<>();
    
    // @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    // private List<Reply> replies = new ArrayList<>();    

    @Builder
    public User(Integer id, String username, String password, String email, String nickname, String userPicUrl,
            String location, Boolean distinguish, Timestamp userCreatedAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.userPicUrl = userPicUrl;
        this.location = location;
        this.distinguish = distinguish;
        this.userCreatedAt = userCreatedAt;
    }
}