package com.example.team_project.product;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.team_project.product.product_pic.ProductPic;
import com.example.team_project.user.User;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private Timestamp productCreatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductPic> productpics = new ArrayList<>();

    @Builder
    public Product(Integer id, String productName, String productDescription, Integer productPrice,
            Timestamp productCreatedAt, User user) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productCreatedAt = productCreatedAt;
        this.user = user;
    }

    // // 2. 생성자 몰아넣기
    //     public void setUpdate(String productName, String productDescription, Integer productPrice) {
    //     this.productName = productName;
    //     this.productDescription = productDescription;
    //     this.productPrice = productPrice;
    // }

    // // 1. 하나씩 생성자.
    // public void setProductName(String productName) {
    //     this.productName = productName;
    // }

    // public void setProductDescription(String productDescription) {
    //     this.productDescription = productDescription;
    // }

    // public void setProductPrice(Integer productPrice) {
    //     this.productPrice = productPrice;
    // }

}
