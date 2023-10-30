package com.example.team_project.reply;

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
        private Integer userId;
        private Timestamp createdAt;

        public ReplyWriteRespDTO(Reply reply) {
            this.id = reply.getId();
            this.comment = reply.getComment();
            this.boardId = reply.getBoard().getId();
            this.userId = reply.getUser().getId();
            this.createdAt = reply.getCreatedAt();
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
