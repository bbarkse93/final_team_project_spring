package com.example.team_project.user;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
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
    private final HttpSession session;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody @Valid UserRequest.JoinReqDTO joinReqDTO, Errors errors) {
        UserResponse.JoinResponseDTO responseDTO = userService.join(joinReqDTO);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
        }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserRequest.LoginReqDTO loginReqDTO, Errors errors) {
            LoginResponseDTO responseDTO = userService.login(loginReqDTO);
            String jwt = responseDTO.getJwt();

        return ResponseEntity.ok().header("Authorization", jwt).body(ApiUtils.success(responseDTO));
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(){
        session.invalidate();
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

}
