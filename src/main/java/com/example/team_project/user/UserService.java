package com.example.team_project.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.team_project.user.UserRequest.LoginDTO;
import com.example.team_project._core.erroes.exception.Exception400;

@Transactional
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserJPARepository userJPARepository;

    @Transactional
    public void join(UserRequest.JoinDTO requestDTO) {

        try {
            userJPARepository.save(requestDTO.toEntity());
        } catch (Exception e) {
            throw new Exception400("존재하는 이메일입니다.");
        }
    }

    public User login(LoginDTO loginDTO) {

        User user = userJPARepository.findByUsername(loginDTO.getUsername());
        if (user == null) {
            throw new Exception400("유저네임이 없습니다.");
        }

        if (!user.getPassword().equals(loginDTO.getPassword())) {
            throw new Exception400("패스워드가 잘못되었습니다.");
        }

        return user;




    }
}
