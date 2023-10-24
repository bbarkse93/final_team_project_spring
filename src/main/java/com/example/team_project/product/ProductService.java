package com.example.team_project.product;

import java.util.List;

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

    public ProductResponse.FindByIdDTO FindById(Integer id) {

        Product product = productJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("상품을 찾을 수 없습니다. ID: " + id));

        List<ProductPic> productPic = productPicJPARepository.findByProductId(product.getId());

        return new ProductResponse.FindByIdDTO(product, productPic);
    }
}
