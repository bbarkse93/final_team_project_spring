package com.example.team_project.user;

import lombok.AllArgsConstructor;
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
    public static class UserLoginRespDTO{
        private String jwt;
        private UserDTO user;

        public UserLoginRespDTO(String jwt, User user) {
            this.jwt = jwt;
            this.user = new UserDTO(user);
        }

        @Getter
        @Setter
        public static class UserDTO {
            private Integer id;
            private String username;
            private String password;
            private Timestamp createdAt;

            public UserDTO(User user) {
                this.id = user.getId();
                this.username = user.getUsername();
                this.password = null;
                this.createdAt = user.getUserCreatedAt();


            }
        }

    }

    @Getter
    @Setter
    public static class UserUpdateRespDTO {
        private Integer id;
        private String username;
        private String nickname;
        private String password;

        public UserUpdateRespDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.nickname = user.getNickname();
            this.password = null;
        }

    }

}
