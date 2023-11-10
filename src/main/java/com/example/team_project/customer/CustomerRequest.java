package com.example.team_project.customer;

import com.example.team_project.board.BoardResponse.BoardDetailRespDTO.ReplyDTO.UserDTO;
import com.example.team_project.user.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CustomerRequest {

    // 문의 등록
    @Getter
    @Setter
    @ToString
    public static class CustomerWriteReqDTO {
        private Integer id;

        private String title;

        private String content;

        // private User user;

        public Customer toEntity() {
            return Customer.builder()
                    .id(id)
                    .title(title)
                    .content(content)
                    // .user(User.builder().id(getId()).build())
                    .build();
        }

    }

}
