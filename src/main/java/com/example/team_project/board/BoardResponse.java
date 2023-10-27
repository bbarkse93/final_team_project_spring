package com.example.team_project.board;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import com.example.team_project.board.board_category.BoardCategory;
import com.example.team_project.board.board_pic.BoardPic;
import com.example.team_project.user.User;

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
        private int id;
        private String boardTitle;
        private String boardContent;
        private Timestamp boardCreatedAt;
        private UserDTO user;
        private BoardCategoryDTO boardCategory;
        private List<BoardPicDTO> boardPics;

        public BoardListRespDTO(Board board) {
            this.id = board.getId();
            this.boardTitle = board.getBoardTitle();
            this.boardContent = board.getBoardContent();
            this.boardCreatedAt = board.getBoardCreatedAt();
            this.user = new UserDTO(board.getUser());
            this.boardCategory = new BoardCategoryDTO(board.getBoardCategory());
            this.boardPics = board.getBoardpics().stream()
                    .limit(1)
                    .map(b -> new BoardPicDTO(b))
                    .collect(Collectors.toList());            
        }

        @Getter
        @Setter
        public static class UserDTO {
            private Integer id;
            private String location;

            public UserDTO(User user) {
                this.id = user.getId();
                this.location = user.getLocation();
            }
        }

        @Getter
        @Setter
        public static class BoardCategoryDTO {
            private Integer id;
            private String boardCategory;

            public BoardCategoryDTO(BoardCategory boardCategory) {
                this.id = boardCategory.getId();
                this.boardCategory = boardCategory.getBoardCategory();
            }
        }

        @Getter
        @Setter
        public static class BoardPicDTO {
            private Integer id;
            private String boardPicUrl;

            public BoardPicDTO(BoardPic boardPics) {
                this.id = boardPics.getId();
                this.boardPicUrl = boardPics.getBoardPicUrl();
            }
        }
    }

    @Getter
    @Setter
    public static class BoardDetailRespDTO {

    }

}
