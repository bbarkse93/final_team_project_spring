package com.example.team_project.user;

import com.example.team_project._core.utils.JwtTokenUtils;
import com.example.team_project.user.UserResponse.UserUpdateRespDTO;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.team_project._core.erroes.exception.Exception400;
import com.example.team_project._core.erroes.exception.Exception404;

@Transactional
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserJPARepository userJPARepository;

    // 회원가입
    @Transactional
    public UserResponse.UserJoinRespDTO join(UserRequest.UserJoinReqDTO userJoinReqDTO) {

        User user;
        try {
            user = userJPARepository.save(userJoinReqDTO.toEntity());
        } catch (Exception e) {
            throw new Exception400("존재하는 이메일입니다.");
        }
        return new UserResponse.UserJoinRespDTO(user);
    }

    // 로그인
    public UserResponse.UserLoginRespDTO login(UserRequest.UserLoginReqDTO userLoginReqDTO) {

        User user = userJPARepository.findByUsername(userLoginReqDTO.getUsername());
        if (user == null) {
            throw new Exception400("유저네임이 없습니다.");
        }

        if (!user.getPassword().equals(userLoginReqDTO.getPassword())) {
            throw new Exception400("패스워드가 잘못되었습니다.");
        }

        String jwt = JwtTokenUtils.create(user);

        return new UserResponse.UserLoginRespDTO(jwt, user);
    }

    // 회원정보수정
    @Transactional
    public UserResponse.UserUpdateRespDTO update(UserRequest.UserUpdateReqDTO userUpdateReqDTO, Integer userId) {

        User user = userJPARepository.findByUsername(userUpdateReqDTO.getUsername());
        if (user.getUsername() == null) {
            throw new Exception404("사용자를 찾을 수 없습니다.");
        } else {
            userJPARepository.mUpdateUser(userId, userUpdateReqDTO.getUsername(),
                    userUpdateReqDTO.getPassword());
            User userOP = userJPARepository.findById(userId).orElseThrow(() -> new Exception400("유저정보가 없습니다."));
            return new UserResponse.UserUpdateRespDTO(userOP);
        }

    }

}
