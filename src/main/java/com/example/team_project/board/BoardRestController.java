package com.example.team_project.board;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_project._core.utils.ApiUtils;
import com.example.team_project.board.BoardRequest.UpdateReqDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardRestController {

    private final BoardService boardService;


    // 동네생활 전체보기
    @GetMapping("/boards")
    public ResponseEntity<?> BoardList(){
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
    public ResponseEntity<?> WriteBoard(@RequestBody BoardRequest.ProductWriteReqDTO ProductWriteReqDTO) {
        BoardResponse.BoardWriteRespDTO responseDTO = boardService.saveBoardWithBoardPics(ProductWriteReqDTO);

        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

        // 동네 생활 게시글 수정
    @PostMapping("/board/update/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable Integer id,
            @RequestBody UpdateReqDTO updateReqDTO) {
        boardService.updateBoardWithBoardPics(id, updateReqDTO);
        return ResponseEntity.ok().body(ApiUtils.success("ok"));
    }
}
