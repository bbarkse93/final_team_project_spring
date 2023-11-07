package com.example.team_project.reply;

import com.example.team_project.board.Board;
import com.example.team_project.reply.reply_like.ReplyLike;
import com.example.team_project.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "reply_tb")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String comment;

    @CreationTimestamp
    private Timestamp replyCreatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @OneToMany(mappedBy = "reply", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ReplyLike> replyLikes = new ArrayList<>();

    @Builder
    public Reply(Integer id, String comment, Timestamp replyCreatedAt, User user, Board board) {
        this.id = id;
        this.comment = comment;
        this.replyCreatedAt = replyCreatedAt;
        this.user = user;
        this.board = board;
    }

    public void ReplyUpdate (String comment) {
        this.comment = comment;
    }
}
