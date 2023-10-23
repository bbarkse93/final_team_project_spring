package com.example.team_project.User;

import lombok.Getter;
import lombok.Setter;

public class UserResponse {

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
