package com.example.team_project.product;

import java.util.List;
import java.util.stream.Collectors;

import com.example.team_project.product.product_pic.ProductPic;
import com.example.team_project.user.User;

import lombok.Getter;
import lombok.Setter;

public class ProductResponse {

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
        }

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

    }

}
