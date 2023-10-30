package com.example.team_project.product;

import java.sql.Timestamp;
import java.util.List;

import com.example.team_project.product.product_pic.ProductPic;
import com.example.team_project.user.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ProductRequest {

    @Getter
    @Setter
    @ToString
    public static class ProductWriteReqDTO {
        private String productName;
        private String productDescription;
        private Integer productPrice;
        private Integer userId;
        private List<String> productPics;

        public Product toEntity() {
            return Product.builder()
                    .productName(productName)
                    .productDescription(productDescription)
                    .productPrice(productPrice)
                    .user(User.builder().id(getUserId()).build())
                    .build();
        }
    }

    @Getter
    @Setter
    @ToString
    public static class ProductUpdateReqDTO {
        private String productName;
        private String productDescription;
        private Integer productPrice;
        private Integer userId;
        private List<ProductPic> productPics;
        private Timestamp createdAt;
    }

}
