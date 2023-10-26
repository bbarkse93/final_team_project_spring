package com.example.team_project.board.board_pic;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.team_project.board.Board;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "board_pic_tb")
public class BoardPic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String BoardPicUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @Builder
    public BoardPic(Integer id, String boardPicUrl, Board board) {
        this.id = id;
        this.BoardPicUrl = boardPicUrl;
        this.board = board;
    }
}
