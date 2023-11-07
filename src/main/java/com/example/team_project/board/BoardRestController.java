package com.example.team_project.board;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_project._core.utils.ApiUtils;
import com.example.team_project.board.BoardRequest.BoardUpdateReqDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardRestController {

    private final BoardService boardService;

    // 동네생활 전체보기
    @GetMapping("/boards")
    public ResponseEntity<?> BoardList() {
        List<BoardResponse.BoardListRespDTO> responseDTO = boardService.FindAll();

        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 동네생활 상세보기
    @GetMapping("/boards/{id}")
    public ResponseEntity<?> BoardDetail(@PathVariable Integer id) {
        BoardResponse.BoardDetailRespDTO responseDTO = boardService.FindById(id);

        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 동네생활 게시글 등록
    @PostMapping("/boards/write")
    public ResponseEntity<?> WriteBoard(@RequestBody BoardRequest.BoardWriteReqDTO boardWriteReqDTO) {
        BoardResponse.BoardWriteRespDTO responseDTO = boardService.saveBoardWithBoardPics(boardWriteReqDTO);

        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 동네 생활 게시글 수정
    @PostMapping("/boards/update/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable Integer id, @RequestBody BoardUpdateReqDTO updateReqDTO) {

        BoardResponse.BoardUpdateRespDTO responseDTO = boardService.updateBoardWithBoardPics(id, updateReqDTO);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 동네생활 게시글 삭제
    @PostMapping("/boards/delete/{id}")
    public ResponseEntity<?> deleteBoard(@RequestBody Integer id) {
        try {
            boardService.deleteBoard(id);
            return ResponseEntity.ok().body(ApiUtils.success("ok"));
        } catch (Exception e) {
            return new ResponseEntity<>("게시글 삭제 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 동네생활 게시글 검색
    @GetMapping("/boards/search")
    public ResponseEntity<?> searchProducts(@RequestParam("keyword") String keyword) {
        List<BoardResponse.BoardSearchRespDTO> responseDTO = boardService.searchBoardsByKeyword(keyword);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 게시글 좋아요 추가
    @PostMapping("/boards/like/{id}")
    public ResponseEntity<?> likeBoard(@PathVariable Integer id,
            @RequestBody @Valid BoardRequest.BoardLikeReqDTO boardLikeReqDTO) {
        BoardResponse.BoardLikeRespDTO responseDTO = boardService.likeBoard(boardLikeReqDTO);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

<<<<<<< HEAD
=======
    // 게시글 좋아요 삭제

>>>>>>> e54e3a104d37c6181191fa17819f5b1f0c7fc7e4
    @PostMapping("/boards/{boardsId}/like/delete/{id}")
    public ResponseEntity<?> deleteLikeBoard(@PathVariable("boardsId") Integer boardsId,
            @PathVariable("id") Integer id) {
        boardService.deleteLikeBoard(boardsId, id);

        return null;
    }

}
