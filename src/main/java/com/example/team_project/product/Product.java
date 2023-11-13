package com.example.team_project.product;

import com.example.team_project.product.product_book_mark.ProductBookmark;
import com.example.team_project.product.product_pic.ProductPic;
import com.example.team_project.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "product_tb")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String productName;

    private String productDescription;

    private Integer productPrice;

    private boolean saleStatus = true;

    @CreationTimestamp
    private Timestamp productCreatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductPic> productPics = new ArrayList<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductBookmark> productBookmarks = new ArrayList<>();



    @Builder
    public Product(Integer id, String productName, String productDescription, Integer productPrice, Timestamp productCreatedAt, User user, List<ProductPic> productPics, List<ProductBookmark> productBookmarks) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productCreatedAt = productCreatedAt;
        this.user = user;
        this.productPics = productPics;
        this.productBookmarks = productBookmarks;
    }
}