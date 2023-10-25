package com.example.team_project.product;

import com.example.team_project.product.product_pic.ProductPic;
import com.example.team_project.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;

public class ProductRequest {

    @Getter
    @Setter
    @ToString
    public static class ProductRequestDTO{
        private String productName;
        private String productDescription;
        private Integer productPrice;
        private Integer userId;
        private List<ProductPic> productPics;
        private Timestamp createdAt;
        private Integer productId;

        public Product toEntity(){
            return Product.builder()
                    .productName(productName)
                    .productDescription(productDescription)
                    .productPrice(productPrice)
                    .user(User.builder().id(getUserId()).build())
                    .build();
        }
    }


}
