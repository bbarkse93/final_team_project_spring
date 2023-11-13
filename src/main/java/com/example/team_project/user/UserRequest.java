package com.example.team_project.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRequest {

    @Getter
    @Setter
    @ToString
    public static class UserLoginReqDTO {
        @NotEmpty
        private String username;

        @NotEmpty
        @Size(min = 8, max = 20, message = "8에서 20자 이내여야 합니다.")
        @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!~`<>,./?;:'\"\\[\\]{}\\\\()|_-])\\S*$", message = "영문, 숫자, 특수문자가 포함되어야하고 공백이 포함될 수 없습니다.")
        private String password;

    }

    @Getter
    @Setter
    @ToString
    public static class UserJoinReqDTO {

        @NotEmpty
        private String username;
        @NotEmpty
        @Email(message = "유효한 이메일 주소를 입력하세요.")
        private String email;
        @NotEmpty
        @Size(min = 8, max = 20, message = "8에서 20자 이내여야 합니다.")
        private String password;

        private String location;

        public User toEntity() {
            return User.builder()
                    .username(username)
                    .email(email)
                    .password(password)
                    .userPicUrl("./images/default-profile.png")
                    .location(location)
                    .build();
        }
    }

    @Getter
    @Setter
    @ToString
    public static class UserUpdateReqDTO {
        private String userPicUrl;
        private String nickname;
        private String password;

        public User toEntity() {
            return User.builder()
                    .userPicUrl(userPicUrl)
                    .nickname(nickname)
                    .password(password)
                    .build();
        }

    }
}
