package com.example.team_project.board.board_pic;

import com.example.team_project.board.Board;
import com.example.team_project.product.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
