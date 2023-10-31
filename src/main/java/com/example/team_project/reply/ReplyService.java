package com.example.team_project.reply;

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

    // 게시글 별 댓글 조회
    public List<ReplyResponse.ReplyListRespDTO> findByBoardId() {

        return null;
    }

    // 댓글 등록
    public ReplyResponse.ReplyWriteRespDTO save(ReplyRequest.ReplyWriteReqDTO replyWriteReqDTO){
        Reply reply = replyJPARepository.save(replyWriteReqDTO.toEntity());
        return new ReplyResponse.ReplyWriteRespDTO(reply);
    }

    // 댓글 수정
    public ReplyResponse.ReplyUpdateRespDTO update(){

        return null;
    }

    // 댓글 삭제
    public ReplyResponse.ReplyDeleteRespDTO delete(){

        return null;
    }
}
