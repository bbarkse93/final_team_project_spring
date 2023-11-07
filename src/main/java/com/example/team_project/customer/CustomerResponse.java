package com.example.team_project.customer;

import com.example.team_project.board.BoardResponse.BoardDetailRespDTO.ReplyDTO.UserDTO;
import com.example.team_project.user.User;

import lombok.Getter;
import lombok.Setter;

public class CustomerResponse {

    // 문의 전체 조회
    @Getter
    @Setter
    public static class CustomerListRespDTO {

    }

    // 문의 상세 조회
    @Getter
    @Setter
    public static class CustomerDetailRespDTO {

    }

    // 문의 등록
    @Getter
    @Setter
    public static class CustomerWriteRespDTO {
        private Integer id;

        private String title;

        private String content;

        private User user;

        public CustomerWriteRespDTO(Customer customer) {
            this.id = customer.getId();
            this.title = customer.getTitle();
            this.content = customer.getContent();
            this.user = customer.getUser();
        }

    }

    // 문의 삭제
    @Getter
    @Setter
    public static class CustomerDeleteRespDTO {

    }
}
