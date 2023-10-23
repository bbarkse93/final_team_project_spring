package com.example.team_project.product;

import com.example.team_project.product.product_pic.ProductPic;

import java.util.List;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ProductResponse {
    @ToString
    @Getter
    @Setter
    public static class FindAllDTO {
        private int id;

        private String productName;

        private Integer productPrice;

        private List<ProductPicUrlDTO> productPics;

        public FindAllDTO(Product product, List<ProductPicUrlDTO> productPics) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.productPrice = product.getProductPrice();
            this.productPics = productPics.stream()
                    .map(t ->  new ProductPicUrlDTO(t))
                    .collect(Collectors.toList());
        }

        @Getter
        @Setter
        class ProductPicUrlDTO {
            private Integer productPicId;
            private String productPicUrl;

            public ProductPicUrlDTO(ProductPic productPic) {
                this.productPicId = productPic.getId();
                this.productPicUrl = productPic.getProductPicUrl();
            }
        }
    }
}
