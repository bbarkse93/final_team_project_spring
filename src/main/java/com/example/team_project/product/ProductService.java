package com.example.team_project.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.team_project.product.product_pic.ProductPic;
import com.example.team_project.product.product_pic.ProductPicJPARepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductJPARepository productJPARepository;
    private final ProductPicJPARepository productPicJPARepository;

    // (기능1) 상품 목록보기
    public ProductResponse.FindAllDTO findAll() {
        List<ProductPic> productPics = productPicJPARepository.findAll();
        System.out.println("테스트 2 : " + productPics);
        ProductResponse.FindAllDTO responseDTO = new ProductResponse.FindAllDTO(productPics);
        System.out.println("테스트 3 : " + responseDTO);

        return responseDTO;
    }

}











// package com.example.team_project.product;

// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.example.team_project.product.product_pic.ProductPic;
// import com.example.team_project.product.product_pic.ProductPicJPARepository;

// import lombok.RequiredArgsConstructor;

// @Transactional
// @RequiredArgsConstructor
// @Service
// public class ProductService {

//     private final ProductJPARepository productJPARepository;
//     private final ProductPicJPARepository productPicJPARepository;

//     // (기능1) 상품 목록보기
//     public ProductResponse.FindAllDTO findAll(Integer id) {
//         List<Product> dtos = productJPARepository.findAll();
//         System.out.println("테스트 1 :" + dtos);
//         ProductPic productPic = productPicJPARepository.findByProductId(id).stream().findFirst().orElse(null);
//         System.out.println("테스트 2 : " + productPic);
//         ProductResponse.FindAllDTO responseDTO = new ProductResponse.FindAllDTO(dtos, productPic);
//         System.out.println("테스트 3 : " + responseDTO);

//         return responseDTO;
//     }

// }