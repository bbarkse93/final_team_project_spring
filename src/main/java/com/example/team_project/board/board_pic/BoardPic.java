package com.example.team_project.board.board_pic;

import javax.persistence.*;

import com.example.team_project.board.Board;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "board_pic_tb")
public class BoardPic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    private String boardPicUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @Builder
    public BoardPic(Integer id, String boardPicUrl, Board board) {
        this.id = id;
        this.boardPicUrl = boardPicUrl;
        this.board = board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    
}
