package com.example.team_project.board.board_category;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "board_category_tb")
public class BoardCategory {
    @Id
    private Integer id;

    private String Category;

    @Builder
    public BoardCategory(Integer id, String Category) {
        this.id = id;
        this.Category = Category;
    }
}
