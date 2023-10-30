package com.example.team_project.board;

import lombok.Getter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_project._core.utils.ApiUtils;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardRestController {

    private final BoardService boardService;

    // 동네생활 전체보기
    @GetMapping("/boards")
    public ResponseEntity<?> BoardList() {
        List<BoardResponse.BoardListRespDTO> responseDTO = boardService.FindAll();

        return ResponseEntity.ok().body(responseDTO);
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









    
    // 동네생활 게시글 삭제
    @PostMapping("/boards/delete/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable Integer id) {
        try {
            boardService.deleteBoard(id);
            return ResponseEntity.ok().body(ApiUtils.success("ok"));
        } catch (Exception e) {
            return new ResponseEntity<>("게시글 삭제 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
