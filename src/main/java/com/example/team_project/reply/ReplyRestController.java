package com.example.team_project.reply;

import com.example.team_project._core.utils.ApiUtils;
import com.example.team_project.product.ProductResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReplyRestController {

    private final ReplyService replyService;

    // 게시글 별 댓글 조회
    @GetMapping("/replies/{id}")
    public ResponseEntity<?> ReplyList() {

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    // 댓글 등록
    @PostMapping("/replies/write")
    public ResponseEntity<?> WriteReply() {

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }


    // 댓글 수정
    @PostMapping("/replies/update")
    public ResponseEntity<?> UpdateReply() {

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    // 댓글 삭제
    @GetMapping("/replies/delete")
    public ResponseEntity<?> DeleteReply() {

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

}
