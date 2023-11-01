package com.example.team_project.reply.reply_like;

import com.example.team_project.board.Board;
import com.example.team_project.reply.Reply;
import com.example.team_project.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="reply_like_tb")
public class ReplyLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Reply reply;

    @Builder
    public ReplyLike(Integer id, User user, Reply reply) {
        this.id = id;
        this.user = user;
        this.reply = reply;
    }
}
