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

        // TODO 1 : JWT토큰 body에 안나오고 header에만 나오도록 수정
        String jwt = JwtTokenUtils.create(user);

        return new UserResponse.UserLoginRespDTO(user, jwt);
    }

    // 회원정보수정
    @Transactional
    public UserResponse.UserUpdateRespDTO update(UserRequest.UserUpdateReqDTO userUpdateReqDTO, Integer userId) {

        // 사용자디비에서 찾아보기
        User user = userJPARepository.findByUsername(userUpdateReqDTO.getUsername());
        if (user.getUsername() == null) {
            throw new Exception404("사용자를 찾을 수 없습니다.");
        } else {
            userJPARepository.mUpdateUser(userId, userUpdateReqDTO.getUsername(),
                    userUpdateReqDTO.getPassword());
            User userOP = userJPARepository.findById(userId).orElseThrow(() -> new Exception400("유저정보가 없습니다."));
            return new UserResponse.UserUpdateRespDTO(userOP);
        }

        // }

        // if (userUpdateReqDTO.getUsername() == null || userUpdateReqDTO.getPassword()
        // == null) {
        // 오류 처리 또는 예외 발생
        // }

        // System.out.println("유저 아이디: " + userdto.getId());
        // System.out.println("유저 네임: " + userdto.getUsername());
        // System.out.println("유저 비밀번호: " + userdto.getPassword());
        // 사용자정보업데이트
        // UserRequest.(userUpdateReqDTO.getUsername());
        // user.setPassword(userUpdateReqDTO.getPassword());

        // 디비에 업데이트된 사용자 정보 저장
        // userJPARepository.save(user);

        // 업데이트된 사용자정보를 응답dto로 변환하여반환
    }

}
