package com.example.team_project.reply;

import com.example.team_project.board.Board;
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

        public Reply toEntity(){
            return Reply.builder()
                    .comment(comment)
                    .board(Board.builder().id(getBoardId()).build())
                    .build();
        }
    }

    @Getter
    @Setter
    @ToString
    public static class ReplyUpdateReqDTO{

    }


}
