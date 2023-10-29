package com.example.team_project.board;

import java.sql.Timestamp;

import java.util.List;
import java.util.stream.Collectors;

import com.example.team_project.board.board_category.BoardCategory;
import com.example.team_project.board.board_pic.BoardPic;
import com.example.team_project.product.ProductResponse;
import com.example.team_project.user.User;

import lombok.Getter;
import lombok.Setter;

public class BoardResponse {

    // 동네생활 전체보기
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
            this.boardPics = board.getBoardPics().stream()
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
                this.boardCategory = boardCategory.getCategory();

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

    // 동네생활 상세보기
    @Getter
    @Setter
    public static class BoardDetailRespDTO {
        private Integer id;
        private String boardTitle;
        private String boardContent;
        private Timestamp boardCreatedAt;
        private UserDTO user;
        private BoardCategoryDTO boardCategory;
        private List<BoardPicDTO> boardPics;

        public BoardDetailRespDTO(Board board, List<BoardPic> boardPics) {
            this.id = board.getId();
            this.boardTitle = board.getBoardTitle();
            this.boardContent = board.getBoardContent();
            this.boardCategory = new BoardCategoryDTO(board.getBoardCategory());
            this.boardCreatedAt = board.getBoardCreatedAt();
            this.user = new UserDTO(board.getUser());
            this.boardPics = boardPics.stream()
                    .map(t -> new BoardPicDTO(t))
                    .collect(Collectors.toList());
        }

        @Getter
        @Setter
        public static class BoardPicDTO {
            private Integer id;
            private String boardPicUrl;

            public BoardPicDTO(BoardPic boardPic) {
                this.id = boardPic.getId();
                this.boardPicUrl = boardPic.getBoardPicUrl();
            }

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

        @Getter
        @Setter
        public static class UserDTO {
            private Integer id;
            private String location;
            private String username;
            private String userPicUrl;

            public UserDTO(User user) {
                this.id = user.getId();
                this.username = user.getUsername();
                this.location = user.getLocation();
                this.userPicUrl = user.getUserPicUrl();
            }
        }

    }

    // 동네생활 게시글 등록
    @Getter
    @Setter
    public static class BoardWriteRespDTO {
        private Integer id;
        private String boardTitle;
        private String boardContent;
        private String boardCategory;
        private UserDTO user;
        private List<BoardPicDTO> boardPics;

        public BoardWriteRespDTO(Board board, List<BoardPic> boardPics, BoardCategory category) {
            this.id = board.getId();
            this.boardTitle = board.getBoardTitle();
            this.boardContent = board.getBoardContent();
            this.boardCategory = category.getCategory();
            this.user = new UserDTO(board.getUser());
            this.boardPics = boardPics.stream()
                    .map(t -> new BoardPicDTO(t))
                    .collect(Collectors.toList());
        }

        @Getter
        @Setter
        public static class UserDTO{
            private Integer userId;
            private String username;
            private String location;

            public UserDTO(User user) {
                this.userId = user.getId();
                this.username = user.getUsername();
                this.location = user.getLocation();
            }

        }

        @Getter
        @Setter
        public static class BoardPicDTO{
            private Integer boardPicId;
            private String boardPicUrl;

            public BoardPicDTO(BoardPic boardPic) {
                this.boardPicId = boardPic.getId();
                this.boardPicUrl = boardPic.getBoardPicUrl();
            }

        }

    }

    // 동네생활 게시글 수정
    @Getter
    @Setter
    public static class BoardUpdateRespDTO {

    }

    // 동네생활 게시글 삭제
    @Getter
    @Setter
    public static class BoardDeleteRespDTO {

    }
  
}
