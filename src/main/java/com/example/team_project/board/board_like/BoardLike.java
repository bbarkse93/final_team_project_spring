package com.example.team_project.board.board_like;

import com.example.team_project.board.Board;
import com.example.team_project.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="board_like_tb")
public class BoardLike {
    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @Builder

    public BoardLike(Integer id, User user, Board board) {
        this.id = id;
        this.user = user;
        this.board = board;
    }
}
