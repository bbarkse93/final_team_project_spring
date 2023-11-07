package com.example.team_project.board;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.team_project.board.board_category.BoardCategory;
import com.example.team_project.board.board_like.BoardLike;
import com.example.team_project.board.board_pic.BoardPic;
import com.example.team_project.user.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;

public class BoardRequest {

    // 동네 생활 게시글 등록
    @Getter
    @Setter
    @ToString
    public static class BoardWriteReqDTO {
        private String boardTitle;
        private String boardContent;
        private Integer boardCategoryId;
        private Integer userId;
        private List<String> boardPics;

        public Board toEntity() {
            return Board.builder()
                    .boardTitle(boardTitle)
                    .boardContent(boardContent)
                    .boardCategory(BoardCategory.builder().id(getBoardCategoryId()).build())
                    .user(User.builder().id(getUserId()).build())
                    .build();
        }

    }

    // 동네 생활 게시글 수정
    @Getter
    @Setter
    @ToString
    public static class BoardUpdateReqDTO {
        private String boardTitle;
        private String boardContent;
        private Integer boardCategoryId;
        private Integer userId;
        private List<String> boardPics;
    }


    // 동네생활 게시글 좋아요
    @Getter
    @Setter
    public static class BoardLikeReqDTO {
        private Integer boardId;
        private Integer userId;

        public BoardLike toEntity() {
            return BoardLike.builder()
                    .board(Board.builder().id(getBoardId()).build())
                    .user(User.builder().id(getUserId()).build())
                    .build();
        }

    }

}
