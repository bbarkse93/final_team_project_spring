package com.example.team_project.User;

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
}
