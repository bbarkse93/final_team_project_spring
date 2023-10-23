package com.example.team_project.user;

import lombok.Getter;
import lombok.Setter;

public class UserResponse {

    @Getter
    @Setter
    public static class LoginResponseDTO {
        private String username;
        private String password;

        public LoginResponseDTO(UserRequest.LoginDTO loginDTO) {
            this.username = loginDTO.getUsername();
            this.password = null;
        }
    }

    @Getter
    @Setter
    public static class JoinResponseDTO {
        private String username;
        private String password;
        private String email;

        public JoinResponseDTO(UserRequest.JoinDTO requestDTO) {
            this.username = requestDTO.getUsername();
            this.password = null;
            this.email = requestDTO.getEmail();

        }
    }
}
