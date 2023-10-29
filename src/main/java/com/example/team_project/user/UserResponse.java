package com.example.team_project.user;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

public class UserResponse {

    @Getter
    @Setter
    public static class UserJoinRespDTO {
        private Integer id;
        private String username;
        private String password;
        private String email;
        private Timestamp createdAt;

        public UserJoinRespDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.password = null;
            this.email = user.getEmail();
            this.createdAt = user.getUserCreatedAt();

        }
    }

    @Getter
    @Setter
    public static class UserLoginRespDTO {
        private Integer id;
        private String username;
        private String password;
        private Timestamp createdAt;
        private String jwt;

        public UserLoginRespDTO(User user, String jwt) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.password = null;
            this.createdAt = user.getUserCreatedAt();
            this.jwt = jwt;
        }
    }

}
