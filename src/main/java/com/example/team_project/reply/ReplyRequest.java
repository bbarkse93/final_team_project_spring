package com.example.team_project.reply;

import com.example.team_project.board.Board;
import com.example.team_project.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ReplyRequest {

    @Getter
    @Setter
    @ToString
    public static class ReplyWriteReqDTO{
        private Integer boardId;
        private String comment;
        private Integer userId;
        public Reply toEntity(){
            return Reply.builder()
                    .comment(comment)
                    .board(Board.builder().id(getBoardId()).build())
                    .user(User.builder().id(getUserId()).build())
                    .build();
        }
    }

    @Getter
    @Setter
    @ToString
    public static class ReplyUpdateReqDTO{

    }


}
