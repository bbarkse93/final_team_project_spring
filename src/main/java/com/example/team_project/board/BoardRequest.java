package com.example.team_project.board;

import java.util.List;

import com.example.team_project.board.board_category.BoardCategory;
import com.example.team_project.board.board_pic.BoardPic;
import com.example.team_project.user.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    @Getter
    @Setter
    @ToString
    public static class BoardUpdateReqDTO {
        private String boardTitle;
        private String boardContent;
        private Integer boardCategoryId;
        private Integer userId;
        private List<BoardPic> boardPics;
    }

    @Getter
    @Setter
    @ToString
    public static class BoardListReqDTO {

    }

    @Getter
    @Setter
    @ToString
    public static class BoardDetailReqDTO {

    }

    @Getter
    @Setter
    public static class BoardCategoryDTO {
        private Integer id;
        private String boardCategory;

        public BoardCategoryDTO(BoardCategory boardCategory) {
            this.id = boardCategory.getId();
            this.boardCategory = boardCategory.getCategory();
        }

    }

}
