package com.example.team_project.board;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import com.example.team_project.board.board_category.BoardCategory;
import com.example.team_project.board.board_like.BoardLike;
import com.example.team_project.board.board_pic.BoardPic;
import com.example.team_project.user.User;

import lombok.Getter;
import lombok.Setter;

public class BoardResponse {

    // 동네생활 전체보기
    @Getter
    @Setter
    public static class BoardListRespDTO {
        private Integer id;
        private String boardTitle;
        private String boardContent;
        private Timestamp createdAt;
        private String boardCategory;
        // 좋아요 카운트
        private long boardLikes;
        private UserDTO user;
        private List<BoardPicDTO> boardPics;

        public BoardListRespDTO(Board board) {
            this.id = board.getId();
            this.boardTitle = board.getBoardTitle();
            this.boardContent = board.getBoardContent();
            this.createdAt = board.getBoardCreatedAt();
            this.boardCategory = board.getBoardCategory().getCategory();
            // this.boardLikes = board.getBoardLikes().stream().map(l -> new
            // BoardLikeDTO(l)).collect(Collectors.toList());
            this.boardLikes = board.getBoardLikes().stream().map(bl -> new BoardLikeDTO(bl)).count();
            this.user = new UserDTO(board.getUser());
            this.boardPics = board.getBoardPics().stream().map(b -> new BoardPicDTO(b)).collect(Collectors.toList());

        }

        @Getter
        @Setter
        public static class BoardPicDTO {
            private Integer boardId;
            private String boardPicUrl;

            public BoardPicDTO(BoardPic boardPic) {
                this.boardId = boardPic.getId();
                this.boardPicUrl = boardPic.getBoardPicUrl();
            }
        }

        @Getter
        @Setter
        public static class UserDTO {
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
        public static class BoardLikeDTO {
            private Integer likeId;
            private Integer userId;

            public BoardLikeDTO(BoardLike boardLike) {
                this.likeId = likeId;
                this.userId = userId;
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
        private String boardCategory;
        private Timestamp boardCreatedAt;
        private long boardLikes;
        private UserDTO user;
        private List<BoardPicDTO> boardPics;

        public BoardDetailRespDTO(Board board, List<BoardPic> boardPics) {
            this.id = board.getId();
            this.boardTitle = board.getBoardTitle();
            this.boardContent = board.getBoardContent();
            this.boardCategory = board.getBoardCategory().getCategory();
            this.boardCreatedAt = board.getBoardCreatedAt();
            this.boardLikes = board.getBoardLikes().stream().map(bl -> new BoardLikeDTO(bl)).count();
            this.user = new UserDTO(board.getUser());
            this.boardPics = boardPics.stream()
                    .map(t -> new BoardPicDTO(t))
                    .collect(Collectors.toList());
        }

        @Getter
        @Setter
        public static class BoardPicDTO {
            private Integer boardPicId;
            private String boardPicUrl;

            public BoardPicDTO(BoardPic boardPic) {
                this.boardPicId = boardPic.getId();
                this.boardPicUrl = boardPic.getBoardPicUrl();
            }

        }

        @Getter
        @Setter
        public static class UserDTO {
            private Integer userId;
            private String location;
            private String username;
            private String userPicUrl;

            public UserDTO(User user) {
                this.userId = user.getId();
                this.username = user.getUsername();
                this.location = user.getLocation();
                this.userPicUrl = user.getUserPicUrl();
            }
        }

        @Getter
        @Setter
        public static class BoardLikeDTO {
            private Integer likeId;
            private Integer userId;

            public BoardLikeDTO(BoardLike boardLike) {
                this.likeId = likeId;
                this.userId = userId;
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
        public static class UserDTO {
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
        public static class BoardPicDTO {
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
        private Integer id;
        private String boardTitle;
        private String boardContent;
        private String boardCategory;
        private UserDTO user;
        private List<BoardPicDTO> boardPics;

        public BoardUpdateRespDTO(Board board, List<BoardPic> boardPics) {
            this.id = board.getId();
            this.boardTitle = board.getBoardTitle();
            this.boardContent = board.getBoardContent();
            this.boardCategory = board.getBoardCategory().getCategory();
            this.user = new UserDTO(board.getUser());
            this.boardPics = boardPics.stream()
                    .map(t -> new BoardPicDTO(t))
                    .collect(Collectors.toList());
        }

        @Getter
        @Setter
        public static class UserDTO {
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
        public static class BoardPicDTO {
            private Integer boardPicId;
            private String boardPicUrl;

            public BoardPicDTO(BoardPic boardPic) {
                this.boardPicId = boardPic.getId();
                this.boardPicUrl = boardPic.getBoardPicUrl();
            }

        }
    }

    // 동네생활 게시글 삭제
    @Getter
    @Setter
    public static class BoardDeleteRespDTO {

    }

    // 동네생활 게시글 검색
    @Getter
    @Setter
    public static class BoardSearchRespDTO {
        private Integer id;
        private String boardTitle;
        private String boardContent;
        private Timestamp createdAt;
        private String boardCategory;
        private UserDTO user;
        private List<BoardPicDTO> boardPics;

        public BoardSearchRespDTO(Board board) {
            this.id = board.getId();
            this.boardTitle = board.getBoardTitle();
            this.boardContent = board.getBoardContent();
            this.createdAt = board.getBoardCreatedAt();
            this.boardCategory = board.getBoardCategory().getCategory();
            this.user = new UserDTO(board.getUser());
            this.boardPics = board.getBoardPics().stream().map(b -> new BoardPicDTO(b)).collect(Collectors.toList());
        }

        @Getter
        @Setter
        public static class BoardPicDTO {
            private Integer boardId;
            private String boardPicUrl;

            public BoardPicDTO(BoardPic boardPic) {
                this.boardId = boardPic.getId();
                this.boardPicUrl = boardPic.getBoardPicUrl();
            }
        }

        @Getter
        @Setter
        public static class UserDTO {
            private Integer userId;
            private String username;
            private String location;

            public UserDTO(User user) {
                this.userId = user.getId();
                this.username = user.getUsername();
                this.location = user.getLocation();
            }
        }
    }
}
