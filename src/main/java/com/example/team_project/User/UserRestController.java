package com.example.team_project.User;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UserService userService;


    @PostMapping("/join")
    public ResponseEntity<?> join(){
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(){
        return null;
    }

}
