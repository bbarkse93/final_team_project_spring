package com.example.team_project.product;

import java.util.List;

import com.example.team_project.product.product_book_mark.ProductBookmark;
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
        private List<String> productPics;
    }

    // 상품북마크
    @Getter
    @Setter
    @ToString
    public static class ProductBookMarkReqDTO {
        private Integer userId;
        private Integer productId;

        public ProductBookmark toEntity() {
            return ProductBookmark.builder()
                    .user(User.builder().id(getUserId()).build())
                    .product(Product.builder().id(getProductId()).build())
                    .build();
        }
    }

}
