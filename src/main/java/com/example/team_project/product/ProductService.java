package com.example.team_project.product;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.team_project._core.erroes.exception.Exception404;

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
        ProductResponse.FindAllDTO responseDTO = new ProductResponse.FindAllDTO(productPics);

        return responseDTO;
    }


    public ProductResponse.FindByIdDTO FindById(Integer id) {

        Product product = productJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("상품을 찾을 수 없습니다. ID: " + id));

        List<ProductPic> productPic = productPicJPARepository.findByProductId(product.getId());

        return new ProductResponse.FindByIdDTO(product, productPic);
    }

    @Transactional
    public void saveProductWithProductPics(ProductRequest.ProductRequestDTO productRequestDTO) {
        Product product = productJPARepository.save(productRequestDTO.toEntity());
        List<ProductPic> productPics = productRequestDTO.getProductPics();
        System.out.println("test"+product.getId());


        for (ProductPic productPic : productPics) {
            System.out.println(productPic.getProductPicUrl());
            productPicJPARepository.save(productPic);
        }
    }
}










