package com.example.team_project.board;

import java.sql.Timestamp;
import java.util.List;

import com.example.team_project.board.board_category.BoardCategory;
import com.example.team_project.board.board_pic.BoardPic;

import lombok.Getter;
import lombok.Setter;

public class BoardResponse {
    @Getter
    @Setter
    public static class WriteRespDTO {

    }

    @Getter
    @Setter
    public static class UpdateRespDTO {

    }

    @Getter
    @Setter
    public static class DeleteRespDTO {

    }

    @Getter
    @Setter
    public static class BoardListRespDTO {

    }

    @Getter
    @Setter
    public static class BoardDetailRespDTO {
        private Integer id;
        private String boardTitle;
        private String boardContent;
        private BoardCategory boardCategory;
        private Timestamp boardCreatedAt;
        private String username;
        private BoardPic boardPic;

        public BoardDetailRespDTO(Board board, BoardPic boardPic) {
            this.id = board.getId();
            this.boardTitle = board.getBoardTitle();
            this.boardContent = board.getBoardContent();
            this.boardCategory = board.getBoardCategory();
            this.boardCreatedAt = board.getBoardCreatedAt();
            this.username = board.getUser().getUsername();
            this.boardPic = boardPic;

        }

    }

}
