package com.example.team_project.product;

import com.example.team_project.product.product_book_mark.ProductBookmark;
import com.example.team_project.product.product_pic.ProductPic;
import com.example.team_project.user.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class ProductResponse {

    // 상품 리스트
    @Getter
    @Setter
    public static class ProductListRespDTO {
        private Integer id;
        private String productName;
        private Integer productPrice;
        private long productLikes;
        private Timestamp productCreatedAt;
        private UserDTO user;
        private List<ProductPicDTO> productPics;
        private boolean saleStatus;

        public ProductListRespDTO(Product product) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.productPrice = product.getProductPrice();
            this.productCreatedAt = product.getProductCreatedAt();
            this.user = new UserDTO(product.getUser());
            this.productLikes = product.getProductBookmarks().stream().map(bl -> new ProductLikeDTO(bl)).count();
            this.productPics = product.getProductPics().stream()
                    .limit(1)
                    .map(p -> new ProductPicDTO(p))
                    .collect(Collectors.toList());
            this.saleStatus = product.isSaleStatus();
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

        @Getter
        @Setter
        public static class ProductLikeDTO {
            private Integer likeId;
            private Integer userId;

            public ProductLikeDTO(ProductBookmark boardLike) {
                this.likeId = likeId;
                this.userId = userId;
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
        private long productLikes;
        private Timestamp productCreatedAt;
        private UserDTO user;
        private List<ProductPicDTO> productPics;
        private boolean saleStatus;

        public ProductDetailRespDTO(Product product, List<ProductPic> productPics) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.productDescription = product.getProductDescription();
            this.productPrice = product.getProductPrice();
            this.productCreatedAt = product.getProductCreatedAt();
            this.user = new UserDTO(product.getUser());
            this.productLikes = product.getProductBookmarks().stream().map(bl -> new ProductLikeDTO(bl)).count();
            this.productPics = productPics.stream().map(t -> new ProductPicDTO(t)).collect(Collectors.toList());
            this.saleStatus = product.isSaleStatus();
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

        @Getter
        @Setter
        public static class ProductLikeDTO {
            private Integer likeId;
            private Integer userId;

            public ProductLikeDTO(ProductBookmark boardLike) {
                this.likeId = boardLike.getId();
                this.userId = boardLike.getUser().getId();
            }
        }
    }

    // 상품 등록
    @Getter
    @Setter
    public static class ProductWriteRespDTO {
        private Integer id;
        private String productName;
        private String productDescription;
        private Integer productPrice;
        private Timestamp createdAt;
        private UserDTO user;
        private List<ProductPicDTO> productPics;
        private boolean saleStatus;

        public ProductWriteRespDTO(Product product, List<ProductPic> productPics, Session sessionUser) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.productDescription = product.getProductDescription();
            this.productPrice = product.getProductPrice();
            this.createdAt = product.getProductCreatedAt();
            this.user = new UserDTO(product.getUser());
            this.productPics = productPics.stream().map(p -> new ProductPicDTO(p)).collect(Collectors.toList());
            this.saleStatus = product.isSaleStatus();
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
            private String username;
            private String nickname;
            private String location;

            public UserDTO(User user) {
                this.userId = user.getId();
                this.username = user.getUsername();
                this.nickname = user.getNickname();
                this.location = user.getLocation();
            }
        }
    }


    // 상품 수정
    @Getter
    @Setter
    public static class ProductUpdateRespDTO {
        private Integer id;
        private String productName;
        private String productDescription;
        private Integer productPrice;
        private Timestamp createdAt;
        private UserDTO user;
        private List<ProductPicDTO> productPics;
        private boolean saleStatus;

        public ProductUpdateRespDTO(Product product, List<ProductPic> productPics) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.productDescription = product.getProductDescription();
            this.productPrice = product.getProductPrice();
            this.createdAt = product.getProductCreatedAt();
            this.user = new UserDTO(product.getUser());
            this.productPics = productPics.stream().map(p -> new ProductPicDTO(p)).collect(Collectors.toList());
            this.saleStatus = product.isSaleStatus();

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
            private String username;
            private String nickname;
            private String location;

            public UserDTO(User user) {
                this.userId = user.getId();
                this.username = user.getUsername();
                this.nickname = user.getNickname();
                this.location = user.getLocation();
            }
        }
    }

    // 상품 검색
    @Getter
    @Setter
    public static class ProductSearchRespDTO {
        private Integer id;
        private String productName;
        private Integer productPrice;
        private Timestamp productCreatedAt;
        private UserDTO user;
        private List<ProductPicDTO> productPics;

        public ProductSearchRespDTO(Product product) {
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
            private String nickname;
            private String location;

            public UserDTO(User user) {
                this.userId = user.getId();
                this.nickname = user.getNickname();
                this.location = user.getLocation();
            }
        }
    }

    // 상품북마크
    @Getter
    @Setter
    public static class ProductBookMarkRespDTO {
        private Integer bookmarkId;
        private Integer productId;

        public ProductBookMarkRespDTO(ProductBookmark productBookMark) {
            this.bookmarkId = productBookMark.getId();
            this.productId = productBookMark.getProduct().getId();
        }
    }

    @Getter
    @Setter
    public static class DeleteBookmarkRespDTO {

    }
}
