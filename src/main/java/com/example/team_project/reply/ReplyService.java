package com.example.team_project.reply;

import com.example.team_project._core.erroes.exception.Exception404;
import com.example.team_project.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyJPARepository replyJPARepository;


    // 댓글 등록
    @Transactional
    public ReplyResponse.ReplyWriteRespDTO save(ReplyRequest.ReplyWriteReqDTO replyWriteReqDTO){
        Reply reply = replyJPARepository.save(replyWriteReqDTO.toEntity());

        return new ReplyResponse.ReplyWriteRespDTO(reply);
    }

    // 댓글 수정
    @Transactional
    public ReplyResponse.ReplyUpdateRespDTO update(Integer id, ReplyRequest.ReplyUpdateReqDTO replyUpdateReqDTO){
        Reply reply = replyJPARepository.findById(id).orElseThrow(() -> new Exception404("댓글을 찾을 수 없습니다."));
        reply.ReplyUpdate(replyUpdateReqDTO.getComment());

        return new ReplyResponse.ReplyUpdateRespDTO(reply);
    }

    // 댓글 삭제
    @Transactional
    public ReplyResponse.ReplyDeleteRespDTO delete(Integer id){
        Reply reply = replyJPARepository.findById(id).orElseThrow(() -> new Exception404("댓글을 찾을 수 없습니다."));
        replyJPARepository.delete(reply);
        return new ReplyResponse.ReplyDeleteRespDTO();
    }
}
