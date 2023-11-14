package com.example.team_project.reply;

import com.example.team_project._core.utils.ApiUtils;
import com.example.team_project.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class ReplyRestController {

    private final ReplyService replyService;
    private final HttpSession session;

    // 댓글 등록
    @PostMapping("/replies/write")
    public ResponseEntity<?> writeReply(@RequestBody ReplyRequest.ReplyWriteReqDTO replyWriteReqDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        ReplyResponse.ReplyWriteRespDTO responseDTO = replyService.save(replyWriteReqDTO, sessionUser);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 댓글 수정
    @PutMapping("/replies/update/{id}")
    public ResponseEntity<?> updateReply(@PathVariable Integer id,
            @RequestBody ReplyRequest.ReplyUpdateReqDTO replyUpdateReqDTO) {
        ReplyResponse.ReplyUpdateRespDTO responseDTO = replyService.update(id, replyUpdateReqDTO);

        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 댓글 삭제
    @DeleteMapping("/replies/{id}")
    public ResponseEntity<?> deleteReply(@PathVariable Integer id) {
        replyService.delete(id);
        return ResponseEntity.ok().body(ApiUtils.success("댓글 삭제 완료"));
    }

}
