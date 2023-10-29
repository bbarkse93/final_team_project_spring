package com.example.team_project.user;


import com.example.team_project._core.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.team_project._core.erroes.exception.Exception400;

@Transactional
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserJPARepository userJPARepository;

    // 회원가입
    @Transactional
    public UserResponse.JoinResponseDTO join(UserRequest.JoinReqDTO joinReqDTO) {

        User user;
        try {
            user = userJPARepository.save(joinReqDTO.toEntity());
        } catch (Exception e) {
            throw new Exception400("존재하는 이메일입니다.");
        }
        return new UserResponse.JoinResponseDTO(user);
    }

    // 로그인
    public UserResponse.LoginResponseDTO login(UserRequest.LoginReqDTO loginReqDTO) {

        User user = userJPARepository.findByUsername(loginReqDTO.getUsername());
        if (user == null) {
            throw new Exception400("유저네임이 없습니다.");
        }

        if (!user.getPassword().equals(loginReqDTO.getPassword())) {
            throw new Exception400("패스워드가 잘못되었습니다.");
        }

        //TODO 1 : JWT토큰 body에 안나오고 header에만 나오도록 수정
        String jwt = JwtTokenUtils.create(user);

        return new UserResponse.LoginResponseDTO(user, jwt);
    }

}
