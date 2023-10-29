package com.example.team_project.board;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

import com.example.team_project._core.erroes.exception.Exception404;
import com.example.team_project.board.BoardResponse.BoardDetailRespDTO;
import com.example.team_project.board.board_pic.BoardPic;
import com.example.team_project.board.board_pic.BoardPicJPARepository;

import com.example.team_project._core.erroes.exception.Exception404;
import com.example.team_project.board.board_category.BoardCategory;
import com.example.team_project.board.board_category.BoardCategoryJPARepository;
import com.example.team_project.board.board_pic.BoardPic;
import com.example.team_project.board.board_pic.BoardPicJPARepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardJPARepository boardJPARepository;
    private final BoardPicJPARepository boardPicJPARepository;
    private final BoardCategoryJPARepository boardCategoryJPARepository;

    // 동네생활 상세보기
    public BoardResponse.BoardDetailRespDTO FindById(Integer id) {
        Board board = boardJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("게시물을 찾을 수 없습니다. ID:" + id));
      
        List<BoardPic> boardPics = boardPicJPARepository.findByBoardId(board.getId());
        System.out.println(boardPics.size());
        // if (boardPics == null) {
        // boardPics = new ArrayList<>(); // boardPics가 null인 경우 빈 리스트로 초기화
        // }

        return new BoardResponse.BoardDetailRespDTO(board, boardPics);
    }


    // 동네 생활 게시글 등록
    @Transactional
    public BoardResponse.WriteRespDTO saveBoardWithBoardPics(BoardRequest.WriteReqDTO writeReqDTO) {
        Board board = boardJPARepository.save(writeReqDTO.toEntity()); // board 등록
       System.out.println("글등록 : "+ board.getBoardTitle()); 

      List<BoardPic> boardPics = writeReqDTO.getBoardPics();

         for (BoardPic boardPic : boardPics) {
             boardPic.setBoard(board);
             boardPicJPARepository.save(boardPic);
         }

        List<BoardPic> boardPicList = boardPicJPARepository.findByBoardId(board.getId());
        BoardCategory boardcCategory = boardCategoryJPARepository.findById(board.getBoardCategory().getId())
        .orElseThrow(() -> new Exception404("Category를 찾을 수 없습니다."));

        return new BoardResponse.WriteRespDTO(board, boardPicList, boardcCategory);
    }

}
