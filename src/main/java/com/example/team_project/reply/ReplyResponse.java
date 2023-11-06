package com.example.team_project.reply;

import com.example.team_project.user.User;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

public class ReplyResponse {

    // 게시글 별 댓글 조회
    @Getter
    @Setter
    public static class ReplyListRespDTO{

    }

    // 댓글 등록
    @Getter
    @Setter
    public static class ReplyWriteRespDTO{
        private Integer id;
        private String comment;
        private Integer boardId;
        private Timestamp replyCreatedAt;
        private long replyLikes;
        private UserDTO user;

        public ReplyWriteRespDTO(Reply reply) {
            this.id = reply.getId();
            this.comment = reply.getComment();
            this.boardId = reply.getBoard().getId();
            this.user = new UserDTO(reply.getUser());
            this.replyCreatedAt = reply.getReplyCreatedAt();
        }

        @Getter
        @Setter
        public static class UserDTO{
            private Integer userId;
            private String username;
            private String userPicUrl;

            public UserDTO(User user) {
                this.userId = user.getId();
                this.username = user.getUsername();
                this.userPicUrl = user.getUserPicUrl();
            }
        }
    }

    // 댓글 수정
    @Getter
    @Setter
    public static class ReplyUpdateRespDTO{

    }

    // 댓글 삭제
    @Getter
    @Setter
    public static class ReplyDeleteRespDTO{

    }
}