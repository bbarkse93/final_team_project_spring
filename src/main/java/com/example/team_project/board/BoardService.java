package com.example.team_project.board;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import com.example.team_project._core.vo.MyPath;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.team_project._core.erroes.exception.Exception404;
import com.example.team_project.board.BoardRequest.BoardUpdateReqDTO;
import com.example.team_project.board.BoardResponse.BoardDeleteRespDTO;
import com.example.team_project.board.BoardResponse.BoardLikeRespDTO;
import com.example.team_project.board.board_category.BoardCategory;
import com.example.team_project.board.board_category.BoardCategoryJPARepository;
import com.example.team_project.board.board_like.BoardLike;
import com.example.team_project.board.board_like.BoardLikeJPARepository;
import com.example.team_project.board.board_pic.BoardPic;
import com.example.team_project.board.board_pic.BoardPicJPARepository;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@Transactional
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardJPARepository boardJPARepository;
    private final BoardPicJPARepository boardPicJPARepository;
    private final BoardCategoryJPARepository boardCategoryJPARepository;
    private final BoardLikeJPARepository boardLikeJPARepository;
    private final EntityManager em;

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

        return new BoardResponse.BoardDetailRespDTO(board);
    }

    // 동네 생활 게시글 등록
    @Transactional
    public BoardResponse.BoardWriteRespDTO saveBoardWithBoardPics(BoardRequest.BoardWriteReqDTO boardWriteReqDTO) {
        Board board = boardJPARepository.save(boardWriteReqDTO.toEntity()); // board 등록

        List<String> boardPicList = boardWriteReqDTO.getBoardPics();

        for (String boardPic : boardPicList) {
            try {
                byte[] boardImages= Base64.getDecoder().decode(boardPic);
                UUID uuid = UUID.randomUUID();
                String filename = board.getBoardTitle() + "_" + uuid + ".png";
                Path filePath = Paths.get(MyPath.IMG_PATH, filename);
                String boardPicUrl = filePath.toString();
                Files.write(filePath, boardImages);
                boardPicJPARepository.mSave(boardPicUrl, board.getId());
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        List<BoardPic> boardPics = boardPicJPARepository.findByBoardId(board.getId());
        BoardCategory boardCategory = boardCategoryJPARepository.findById(board.getBoardCategory().getId())
                .orElseThrow(() -> new Exception404("Category를 찾을 수 없습니다."));

        return new BoardResponse.BoardWriteRespDTO(board, boardPics, boardCategory);
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

        // 1. 해당 보드 id에 담긴 원래 사진들을 삭제.
        boardPicJPARepository.deleteByBoardId(board.getId());
        // 2. DTO에 담겨있던 사진을 저장.
        List<String> boardPicList = updateReqDTO.getBoardPics();

        for (String boardPic : boardPicList) {

            boardPicJPARepository.mSave(boardPic, board.getId());
        }

        BoardCategory optionalCategory = boardCategoryJPARepository.findById(updateReqDTO.getBoardCategoryId())
                .orElseThrow(() -> new Exception404("카테고리를 찾을 수 없습니다."));

        board.setBoardCategory(optionalCategory);

        board = boardJPARepository.save(board);

        em.refresh(board);

        return new BoardResponse.BoardUpdateRespDTO(board);
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
    public BoardResponse.BoardLikeRespDTO likeBoard(BoardRequest.BoardLikeReqDTO boardLikeReqDTO) {
        BoardLike boardLike = boardLikeJPARepository.save(boardLikeReqDTO.toEntity());
        return new BoardResponse.BoardLikeRespDTO(boardLike);
    }

    // 게시글 좋아요 삭제
    @Transactional
    public BoardResponse.BoardDeleteRespDTO deleteLikeBoard(Integer id) {
        boardLikeJPARepository.deleteById(id);
        return null;
    }

}
