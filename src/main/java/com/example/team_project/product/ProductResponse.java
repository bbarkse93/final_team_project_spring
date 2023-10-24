package com.example.team_project.product;


import java.sql.Timestamp;

import java.util.List;
import java.util.stream.Collectors;

import com.example.team_project.product.product_pic.ProductPic;
import com.example.team_project.user.User;

import lombok.Getter;
import lombok.Setter;

public class ProductResponse {

    // 상품 리스트
    @Getter
    @Setter
    public static class FindAllDTO {
        private List<ProductListDTO> products;

        public FindAllDTO(List<ProductPic> productPicList) {
            this.products = productPicList.stream()
                    .map(t -> t.getProduct()).distinct()
                    .map(p -> new ProductListDTO(p, productPicList))
                    .collect(Collectors.toList());
        }

        @Getter
        @Setter
        public static class ProductListDTO {
            private int id;
            private String productName;
            private Integer productPrice;
            private Timestamp productCreatedAt;
            private UserDTO user;
            private List<ProductPicDTO> productPics;

            public ProductListDTO(Product product, List<ProductPic> productPicList) {
                this.id = product.getId();
                this.productName = product.getProductName();
                this.productPrice = product.getProductPrice();
                this.productCreatedAt = product.getProductCreatedAt();
                this.user = new UserDTO(product.getUser());
                this.productPics = productPicList.stream()
                        .filter(p -> p.getProduct().getId() == product.getId())
                        .limit(1)
                        .map(p -> new ProductPicDTO(p))
                        .collect(Collectors.toList());
            }
        }

        @Getter
        @Setter
        public static class ProductPicDTO {
            private Integer id;
            private String productPicUrl;

            public ProductPicDTO(ProductPic productPic) {
                this.id = productPic.getId();
                this.productPicUrl = productPic.getProductPicUrl();
            }
        }
      
        @Getter
        @Setter
        public static class UserDTO {
            private Integer id;
            private String location;
            public UserDTO(User user) {
                this.id = user.getId();
                this.location = user.getLocation();
            }
        }
    }

  
    // 상품상세보기
    @Getter
    @Setter
    public static class FindByIdDTO {
        private Integer id;
        private String productName;
        private String productDescription;
        private Integer productPrice;
        private List<ProductPicDTO> ProductPics;
        private UserDTO user;

        public FindByIdDTO(Product product, List<ProductPic> productPics) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.productDescription = product.getProductDescription();
            this.productPrice = product.getProductPrice();
            ProductPics = productPics.stream().map(t -> new ProductPicDTO(t)).collect(Collectors.toList());
            this.user = new UserDTO(product.getUser());

            @Getter
            @Setter
            public static class UserDTO {
                private Integer id;
                private String location;
                private String username;
                private String userPicUrl;

                public UserDTO(User user) {
                    this.id = user.getId();
                    this.username = user.getUsername();
                    this.location = user.getLocation();
                    this.userPicUrl = user.getUserPicUrl();
                }
            }
        }
    }
}





