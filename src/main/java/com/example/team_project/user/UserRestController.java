package com.example.team_project.user;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.team_project.user.UserResponse.LoginResponseDTO;
import com.example.team_project.user.UserResponse.JoinResponseDTO;
import com.example.team_project._core.utils.ApiUtils;

@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody @Valid UserRequest.JoinDTO requestDTO, Errors errors) {
            userService.join(requestDTO);
            JoinResponseDTO response = new JoinResponseDTO(requestDTO);
        return ResponseEntity.ok().body(ApiUtils.success(response));
        }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserRequest.LoginDTO requestDTO, Errors errors) {
            userService.login(requestDTO);
            LoginResponseDTO responseDTO = new LoginResponseDTO(requestDTO);

        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
        }

    }
