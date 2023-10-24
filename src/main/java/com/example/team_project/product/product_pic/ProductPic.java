package com.example.team_project.product.product_pic;

import com.example.team_project.product.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
