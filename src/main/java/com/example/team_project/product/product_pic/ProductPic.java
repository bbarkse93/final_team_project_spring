package com.example.team_project.product.product_pic;

import javax.persistence.*;

import com.example.team_project.product.Product;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "product_pic_tb")
public class ProductPic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    private String productPicUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Builder
    public ProductPic(Integer id, String productPicUrl, Product product) {
        this.id = id;
        this.productPicUrl = productPicUrl;
        this.product = product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
