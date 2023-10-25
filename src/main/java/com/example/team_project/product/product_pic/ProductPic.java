package com.example.team_project.product.product_pic;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.team_project.product.Product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "product_pic_tb")
public class ProductPic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ProductPicUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public ProductPic(Integer id, String productPicUrl, Product product) {
        this.id = id;
        this.ProductPicUrl = productPicUrl;
        this.product = product;
    }
}
