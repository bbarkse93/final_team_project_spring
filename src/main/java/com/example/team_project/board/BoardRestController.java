package com.example.team_project.board;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_project._core.utils.ApiUtils;
import com.example.team_project.product.ProductRequest;

@RequiredArgsConstructor
@RestController
public class BoardRestController {

    private final BoardService boardService;

    // 동네생활 상세보기
    @GetMapping("/board/{id}")
    public ResponseEntity<?> FindById(@PathVariable Integer id) {
        BoardResponse.BoardDetailRespDTO responseDTO = boardService.FindById(id);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 동네생활 등록
    @PostMapping("/board/write")
    public ResponseEntity<?> WriteBoard(@RequestBody BoardRequest.WriteReqDTO writeReqDTO) {
        boardService.saveBoardWithBoardtPics(writeReqDTO);
        return ResponseEntity.ok().body(ApiUtils.success("ok"));
    }
}
