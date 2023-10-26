package com.example.team_project.board;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_project._core.utils.ApiUtils;

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

}
