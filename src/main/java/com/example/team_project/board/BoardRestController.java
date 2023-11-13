package com.example.team_project.board;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.example.team_project._core.utils.ApiUtils;
import com.example.team_project.board.BoardRequest.BoardUpdateReqDTO;
import com.example.team_project.user.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardRestController {

    private final BoardService boardService;
    private final HttpSession session;

    // 동네생활 전체보기
    @GetMapping("/boards")
    public ResponseEntity<?> boardList() {
        List<BoardResponse.BoardListRespDTO> responseDTO = boardService.FindAll();

        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 동네생활 상세보기
    @GetMapping("/boards/{id}")
    public ResponseEntity<?> boardDetail(@PathVariable Integer id) {
        BoardResponse.BoardDetailRespDTO responseDTO = boardService.FindById(id);

        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 동네생활 게시글 등록
    @PostMapping("/boards/write")
    public ResponseEntity<?> writeBoard(@RequestBody BoardRequest.BoardWriteReqDTO boardWriteReqDTO, Errors errors) {

        if (errors.hasErrors()){
            FieldError fieldError = errors.getFieldErrors().get(0);
            String key = fieldError.getField();
            String value = fieldError.getDefaultMessage();

        }
        System.out.println("1.............`````````````````````````````````````````````````````````````");
        User sessionUser = (User) session.getAttribute("sessionUser");
        System.out.println("세션 가져오나? : "+sessionUser.getUsername());
        BoardResponse.BoardWriteRespDTO responseDTO = boardService.saveBoardWithBoardPics(boardWriteReqDTO, sessionUser);
        try {

    return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
        }catch (Exception e){
    e.printStackTrace();
}
    return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 동네 생활 게시글 수정
    @PostMapping("/boards/update/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable Integer id, @RequestBody BoardUpdateReqDTO updateReqDTO) {

        BoardResponse.BoardUpdateRespDTO responseDTO = boardService.updateBoardWithBoardPics(id, updateReqDTO);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 동네생활 게시글 삭제
    @DeleteMapping("/boards/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable Integer id) {
        try {
            boardService.deleteBoard(id);
            return ResponseEntity.ok().body(ApiUtils.success("ok"));
        } catch (Exception e) {
            return new ResponseEntity<>("게시글 삭제 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 동네 생활 게시글 검색
    @GetMapping("/boards/search")
    public ResponseEntity<?> searchProducts(@RequestParam("keyword") String keyword) {
        List<BoardResponse.BoardSearchRespDTO> responseDTO = boardService.searchBoardsByKeyword(keyword);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 게시글 좋아요 추가
    @PostMapping("/boards/like")
    public ResponseEntity<?> likeBoard(@RequestBody @Valid BoardRequest.BoardLikeReqDTO boardLikeReqDTO) {
        BoardResponse.BoardLikeRespDTO responseDTO = boardService.likeBoard(boardLikeReqDTO);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 게시글 좋아요 삭제
    @DeleteMapping("/boards/like/{id}")
    public ResponseEntity<?> deleteLikeBoard(@PathVariable Integer id) {
        boardService.deleteLikeBoard(id);
        return ResponseEntity.ok().body(ApiUtils.success("좋아요 취소 완료"));

    }

}
