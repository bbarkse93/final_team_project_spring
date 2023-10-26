package com.example.team_project.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardRestController {

    private final BoardService boardService;

}
