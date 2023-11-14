package com.example.team_project.reply;

import com.example.team_project._core.erroes.exception.Exception404;
import com.example.team_project.user.User;
import com.example.team_project.user.UserJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyJPARepository replyJPARepository;
    private final UserJPARepository userJPARepository;

    // 댓글 등록
    @Transactional
    public ReplyResponse.ReplyWriteRespDTO save(ReplyRequest.ReplyWriteReqDTO replyWriteReqDTO, User sessionUser) {
        replyWriteReqDTO.setUserId(sessionUser.getId());
        Reply sreply = replyJPARepository.save(replyWriteReqDTO.toEntity());

        User user = userJPARepository.findById(sreply.getUser().getId())
                .orElseThrow(() -> new Exception404("유저정보 없음"));

        Reply reply = replyJPARepository.findById(sreply.getId())
                .orElseThrow(() -> new Exception404("댓글을 찾을 수 없습니다. ID: " + sreply.getId()));

        reply.addUserInfo(user);

        return new ReplyResponse.ReplyWriteRespDTO(reply);
    }

    // 댓글 수정
    @Transactional
    public ReplyResponse.ReplyUpdateRespDTO update(Integer id, ReplyRequest.ReplyUpdateReqDTO replyUpdateReqDTO) {
        Reply reply = replyJPARepository.findById(id).orElseThrow(() -> new Exception404("댓글을 찾을 수 없습니다."));
        reply.ReplyUpdate(replyUpdateReqDTO.getComment());

        return new ReplyResponse.ReplyUpdateRespDTO(reply);
    }

    // 댓글 삭제
    @Transactional
    public ReplyResponse.ReplyDeleteRespDTO delete(Integer id) {
        Reply reply = replyJPARepository.findById(id).orElseThrow(() -> new Exception404("댓글을 찾을 수 없습니다."));
        replyJPARepository.delete(reply);
        return new ReplyResponse.ReplyDeleteRespDTO();
    }
}
