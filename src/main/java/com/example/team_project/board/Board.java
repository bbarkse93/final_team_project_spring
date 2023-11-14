package com.example.team_project.board;

import com.example.team_project.board.board_category.BoardCategory;
import com.example.team_project.board.board_like.BoardLike;
import com.example.team_project.board.board_pic.BoardPic;
import com.example.team_project.reply.Reply;
import com.example.team_project.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "board_tb")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String boardTitle;

    private String boardContent;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private BoardCategory boardCategory;

    @CreationTimestamp
    private Timestamp boardCreatedAt;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BoardPic> boardPics = new ArrayList<>();

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BoardLike> boardLikes = new ArrayList<>();

    // @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    // private List<Board> boards = new ArrayList<>();

    public void addUserInfo(User user) {
        this.user = user;
    }

    @Builder
    public Board(Integer id, String boardTitle, String boardContent, User user, BoardCategory boardCategory,
                 Timestamp boardCreatedAt, List<BoardPic> boardPics, List<Reply> replies, List<BoardLike> boardLikes) {
        this.id = id;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.user = user;
        this.boardCategory = boardCategory;
        this.boardCreatedAt = boardCreatedAt;
        this.boardPics = boardPics;
        this.replies = replies;
        this.boardLikes = boardLikes;
    }

    public void setBoardCategory(BoardCategory boardCategory) {
        this.boardCategory = boardCategory;
    }
}
