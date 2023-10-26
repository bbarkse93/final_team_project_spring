package com.example.team_project.board;

import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

import com.example.team_project._core.erroes.exception.Exception404;
import com.example.team_project.board.BoardRequest.WriteReqDTO;
import com.example.team_project.board.BoardResponse.BoardDetailRespDTO;
import com.example.team_project.board.board_pic.BoardPic;
import com.example.team_project.board.board_pic.BoardPicJPARepository;
import com.example.team_project.product.product_pic.ProductPic;

@Transactional
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardJPARepository boardJPARepository;
    private final BoardPicJPARepository boardPicJPARepository;

    // 동네생활 상세보기
    public BoardResponse.BoardDetailRespDTO FindById(Integer id) {
        Board board = boardJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("게시물을 찾을 수 없습니다. ID:" + id));

        List<BoardPic> boardPics = boardPicJPARepository.findByBoardId(board.getId());
        System.out.println(boardPics.size());
        if (boardPics == null) {
            boardPics = new ArrayList<>(); // boardPics가 null인 경우 빈 리스트로 초기화
        }

        return new BoardResponse.BoardDetailRespDTO(board, boardPics);
    }

    // 동네생활글등록
    @Transactional
    public void saveBoardWithBoardtPics(BoardRequest.WriteReqDTO writeReqDTO) {
        Board board = boardJPARepository.save(writeReqDTO.toEntity());
        List<BoardPic> boardPics = writeReqDTO.getBoardPics();

        for (BoardPic boardPic : boardPics) {
            System.out.println(boardPic.getBoardPicUrl());
            boardPicJPARepository.save(boardPic);
        }
    }

}
