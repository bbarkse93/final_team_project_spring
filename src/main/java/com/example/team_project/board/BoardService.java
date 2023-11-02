package com.example.team_project.board;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.team_project._core.erroes.exception.Exception404;
import com.example.team_project.board.BoardRequest.BoardUpdateReqDTO;
import com.example.team_project.board.BoardResponse.BoardLikeRespDTO;
import com.example.team_project.board.board_category.BoardCategory;
import com.example.team_project.board.board_category.BoardCategoryJPARepository;
import com.example.team_project.board.board_like.BoardLike;
import com.example.team_project.board.board_like.BoardLikeJPARepository;
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
    private final BoardLikeJPARepository boardLikeJPARepository;

    // 동네 생활 전체 보기
    public List<BoardResponse.BoardListRespDTO> FindAll() {
        List<Board> boards = boardJPARepository.mFindAllJoinBoardCategoryAndBoardPic();

        List<BoardResponse.BoardListRespDTO> responseDTO = boards.stream()
                .distinct()
                .map(b -> {
                    BoardResponse.BoardListRespDTO boardDTO = new BoardResponse.BoardListRespDTO(b);
                    List<BoardResponse.BoardListRespDTO.BoardPicDTO> boardPicDTOs = b.getBoardPics().isEmpty() ? null
                            : b.getBoardPics().stream()
                                    .limit(1)
                                    .map(bp -> new BoardResponse.BoardListRespDTO.BoardPicDTO(bp))
                                    .collect(Collectors.toList());
                    boardDTO.setBoardPics(boardPicDTOs);
                    return boardDTO;
                })
                .collect(Collectors.toList());

        return responseDTO;
    }

    // 동네생활 상세보기
    public BoardResponse.BoardDetailRespDTO FindById(Integer id) {
        Board board = boardJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("게시물을 찾을 수 없습니다. ID:" + id));

        List<BoardPic> boardPics = boardPicJPARepository.findByBoardId(board.getId());
        // TODO: boardPics에 값이 없으면 빈 리스트가 아닌 null이 출력되게 수정해야 함
        return new BoardResponse.BoardDetailRespDTO(board, boardPics);
    }

    // 동네 생활 게시글 등록
    @Transactional
    public BoardResponse.BoardWriteRespDTO saveBoardWithBoardPics(BoardRequest.BoardWriteReqDTO boardWriteReqDTO) {
        Board board = boardJPARepository.save(boardWriteReqDTO.toEntity()); // board 등록

        List<String> boardPicList = boardWriteReqDTO.getBoardPics();

        for (String boardPic : boardPicList) {

            boardPicJPARepository.mSave(boardPic, board.getId());
        }

        List<BoardPic> boardPics = boardPicJPARepository.findByBoardId(board.getId());
        BoardCategory boardcCategory = boardCategoryJPARepository.findById(board.getBoardCategory().getId())
                .orElseThrow(() -> new Exception404("Category를 찾을 수 없습니다."));

        return new BoardResponse.BoardWriteRespDTO(board, boardPics, boardcCategory);
    }

    // 동네 생활 게시글 수정
    @Transactional
    public BoardResponse.BoardUpdateRespDTO updateBoardWithBoardPics(Integer id, BoardUpdateReqDTO updateReqDTO) {
        Board board = boardJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("게시글을 찾을 수 없습니다. " + id));

        boardJPARepository.updateBoard(
                board.getId(),
                updateReqDTO.getBoardContent(),
                updateReqDTO.getBoardTitle());

        List<BoardPic> boardPics = updateReqDTO.getBoardPics();

        for (BoardPic boardPic : boardPics) {
            boardPicJPARepository.updateBoardPic(board.getId(),
                    boardPic.getBoardPicUrl());
        }

        Integer boardCategoryId = updateReqDTO.getBoardCategoryId();
        Optional<BoardCategory> optionalCategory = boardCategoryJPARepository.findById(boardCategoryId);
        BoardCategory newCategory = optionalCategory.get();
        board.setBoardCategory(newCategory);
        boardJPARepository.save(board);

        return new BoardResponse.BoardUpdateRespDTO(board, boardPics);
    }

    // 동네 생활 게시글 삭제
    @Transactional
    public void deleteBoard(int boardId) {
        // 먼저 해당 게시글의 이미지를 삭제
        List<BoardPic> boardPics = boardPicJPARepository.findByBoardId(boardId);
        for (BoardPic boardPic : boardPics) {
            boardPicJPARepository.delete(boardPic);
        }

        // 그 다음 게시글을 삭제
        boardJPARepository.deleteById(boardId);
    }

    // 동네 생활 게시글 검색
    public List<BoardResponse.BoardSearchRespDTO> searchBoardsByKeyword(String keyword) {
        List<Board> boardList = boardJPARepository.findByBoardTitleContaining(keyword);

        List<BoardResponse.BoardSearchRespDTO> responseDTO = boardList.stream()
                .distinct()
                .map(p -> {
                    BoardResponse.BoardSearchRespDTO boardDTO = new BoardResponse.BoardSearchRespDTO(p);
                    List<BoardResponse.BoardSearchRespDTO.BoardPicDTO> boardPicDTOs = p.getBoardPics()
                            .isEmpty()
                                    ? null
                                    : p.getBoardPics().stream()
                                            .limit(1)
                                            .map(pp -> new BoardResponse.BoardSearchRespDTO.BoardPicDTO(pp))
                                            .collect(Collectors.toList());
                    boardDTO.setBoardPics((boardPicDTOs));
                    return boardDTO;
                })
                .collect(Collectors.toList());

        return responseDTO;
    }

    // 게시글 좋아요
    @Transactional
    public BoardResponse.BoardLikeRespDTO LikeBoard(BoardRequest.BoardLikeReqDTO boardLikeReqDTO) {
        // BoardLike entity 생성 및 저장
        // BoardLike boardLike = new BoardLike(boardLikeReqDTO.getBoardId(),
        // boardLikeReqDTO.getUserId());
        BoardLike boardLike = boardLikeJPARepository.save(boardLikeReqDTO.toEntiy());
        return new BoardResponse.BoardLikeRespDTO(boardLike);
    }
}
