package com.example.team_project.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import com.example.team_project.board.Board;
import com.example.team_project.board.board_like.BoardLike;
import com.example.team_project.board.board_pic.BoardPic;
import com.example.team_project.reply.Reply;

public class UserResponse {

    @Getter
    @Setter
    public static class UserJoinRespDTO {
        private Integer id;
        private String username;
        private String password;
        private String email;
        private String location;
        private Timestamp createdAt;

        public UserJoinRespDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.password = null;
            this.email = user.getEmail();
            this.location = user.getLocation();
            this.createdAt = user.getUserCreatedAt();

        }
    }

    @Getter
    @Setter
    public static class UserLoginRespDTO {
        private String jwt;
        private UserDTO user;

        public UserLoginRespDTO(String jwt, User user) {
            this.jwt = jwt;
            this.user = new UserDTO(user);
        }

        @Getter
        @Setter
        public static class UserDTO {
            private Integer id;
            private String username;
            private String nickname;
            private String password;
            private Timestamp createdAt;

            public UserDTO(User user) {
                this.id = user.getId();
                this.username = user.getUsername();
                this.nickname = user.getNickname();
                this.password = null;
                this.createdAt = user.getUserCreatedAt();

            }
        }

    }

    @Getter
    @Setter
    public static class UserUpdateRespDTO {
        private Integer id;
        private String username;
        private String nickname;
        private String password;

        public UserUpdateRespDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.nickname = user.getNickname();
            this.password = null;
        }

    }

    // 동네생활 쓴글,댓글
    @Getter
    @Setter
    public static class MyWriteRespDTO {
        private List<WriteBoardsDTO> boardWrites;
        private List<WriteBoardsDTO> replyWrites;

        public MyWriteRespDTO(List<Board> board, List<Board> replies) {
            this.boardWrites = board.stream().map(b -> new WriteBoardsDTO(b)).collect(Collectors.toList());
            this.replyWrites = replies.stream().map(r -> new WriteBoardsDTO(r)).collect(Collectors.toList());
        }

        @Getter
        @Setter
        public static class WriteBoardsDTO {
            private Integer id;
            private String boardTitle;
            private String boardContent;
            private Timestamp createdAt;
            private String boardCategory;
            private long boardLikes;
            private long replyCount;
            private UserDTO user;
            private List<BoardPicDTO> boardPics;

            public WriteBoardsDTO(Board board) {
                this.id = board.getId();
                this.boardTitle = board.getBoardTitle();
                this.boardContent = board.getBoardContent();
                this.createdAt = board.getBoardCreatedAt();
                this.boardCategory = board.getBoardCategory().getCategory();
                this.boardLikes = board.getBoardLikes().stream().map(bl -> new BoardLikeDTO(bl)).count();
                this.replyCount = board.getReplies().stream().map(bl -> new ReplyDTO(bl)).count();
                this.user = new UserDTO(board.getUser());
                this.boardPics = board.getBoardPics().stream().limit(1).map(b -> new BoardPicDTO(b))
                        .collect(Collectors.toList());
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
                    this.likeId = boardLike.getId();
                    this.userId = boardLike.getUser().getId();
                }
            }

            @Getter
            @Setter
            public static class ReplyDTO {
                private Integer replyId;

                public ReplyDTO(Reply reply) {
                    this.replyId = reply.getId();
                }
            }
        }
    }

}
