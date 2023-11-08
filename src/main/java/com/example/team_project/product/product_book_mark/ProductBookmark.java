package com.example.team_project.product.product_book_mark;

import javax.persistence.*;

import com.example.team_project.product.Product;
import com.example.team_project.user.User;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "product_bookmark_tb")
public class ProductBookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Builder
    public ProductBookmark(Integer id, User user, Product product) {
        this.id = id;
        this.user = user;
        this.product = product;
    }
}
