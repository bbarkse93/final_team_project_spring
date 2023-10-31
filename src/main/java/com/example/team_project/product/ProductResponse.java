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
    public static class ProductListRespDTO {
        private Integer id;
        private String productName;
        private Integer productPrice;
        private Timestamp productCreatedAt;
        private UserDTO user;
        private List<ProductPicDTO> productPics;

        public ProductListRespDTO(Product product) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.productPrice = product.getProductPrice();
            this.productCreatedAt = product.getProductCreatedAt();
            this.user = new UserDTO(product.getUser());
            this.productPics = product.getProductPics().stream()
                    .limit(1)
                    .map(p -> new ProductPicDTO(p))
                    .collect(Collectors.toList());
        }

        @Getter
        @Setter
        public static class ProductPicDTO {
            private Integer productPicId;
            private String productPicUrl;

            public ProductPicDTO(ProductPic productPic) {
                this.productPicId = productPic.getId();
                this.productPicUrl = productPic.getProductPicUrl();
            }
        }

        @Getter
        @Setter
        public static class UserDTO {
            private Integer userId;
            private String location;

            public UserDTO(User user) {
                this.userId = user.getId();
                this.location = user.getLocation();
            }
        }
    }

    // 상품상세보기
    @Getter
    @Setter
    public static class ProductDetailRespDTO {
        private Integer id;
        private String productName;
        private String productDescription;
        private Integer productPrice;
        private Timestamp createdAt;
        private UserDTO user;
        private List<ProductPicDTO> productPics;

        public ProductDetailRespDTO(Product product, List<ProductPic> productPics) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.productDescription = product.getProductDescription();
            this.productPrice = product.getProductPrice();
            this.createdAt = product.getProductCreatedAt();
            this.user = new UserDTO(product.getUser());
            this.productPics = productPics.stream().map(t -> new ProductPicDTO(t)).collect(Collectors.toList());

        }

        @Getter
        @Setter
        public static class UserDTO {
            private Integer userId;
            private String location;
            private String username;
            private String userPicUrl;

            public UserDTO(User user) {
                this.userId = user.getId();
                this.username = user.getUsername();
                this.location = user.getLocation();
                this.userPicUrl = user.getUserPicUrl();
            }
        }

        @Getter
        @Setter
        public static class ProductPicDTO {
            private Integer productPicId;
            private String productPicUrl;

            public ProductPicDTO(ProductPic productPicDTOs) {
                this.productPicId = productPicDTOs.getId();
                this.productPicUrl = productPicDTOs.getProductPicUrl();
            }
        }
    }

    // 상품 등록
    @Getter
    @Setter
    public static class ProductWriteRespDTO{
        private Integer id;
        private String productName;
        private String productDescription;
        private Integer productPrice;
        private Timestamp createdAt;
        private UserDTO user;
        private List<ProductPicDTO> productPics;

        public ProductWriteRespDTO(Product product, List<ProductPic> productPics) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.productDescription = product.getProductDescription();
            this.productPrice = product.getProductPrice();
            this.createdAt = product.getProductCreatedAt();
            this.user = new UserDTO(product.getUser());
            this.productPics = productPics.stream().map(p -> new ProductPicDTO(p)).collect(Collectors.toList());
        }

        @Getter
        @Setter
        public static class ProductPicDTO{
            private Integer productPicId;
            private String productPicUrl;

            public ProductPicDTO(ProductPic productPic) {
                this.productPicId = productPic.getId();
                this.productPicUrl = productPic.getProductPicUrl();
            }
        }

        @Getter
        @Setter
        public static class UserDTO{
            private Integer userId;
            private String username;
            private String location;

            public UserDTO(User user) {
                this.userId = user.getId();
                this.username = user.getUsername();
                this.location = user.getLocation();
            }
        }
    }

    // 상품 수정        
    @Getter
    @Setter
    public static class ProductUpdateRespDTO{
        private Integer id;
        private String productName;
        private String productDescription;
        private Integer productPrice;
        private Timestamp createdAt;
        private List<ProductPicDTO> productPics;

        public ProductUpdateRespDTO(Product product, List<ProductPic> productPics) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.productDescription = product.getProductDescription();
            this.productPrice = product.getProductPrice();
            this.createdAt = product.getProductCreatedAt();
            this.productPics = productPics.stream().map(p -> new ProductPicDTO(p)).collect(Collectors.toList());
        }

        @Getter
        @Setter
        public static class ProductPicDTO{
            private Integer productPicId;
            private String productPicUrl;

            public ProductPicDTO(ProductPic productPic) {
                this.productPicId = productPic.getId();
                this.productPicUrl = productPic.getProductPicUrl();
            }
        }
    }
}


