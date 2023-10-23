package com.example.team_project.product;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.team_project._core.erroes.exception.Exception404;
import com.example.team_project.product.product_pic.ProductPic;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductService productService;

    Product productPS = productJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("해당 id의 상품을 찾을 수 없습니다 : " + id));

        List<ProductPic> optionsPS = POJPA.findByProductId(id);

        return new ProductResponse.FindByIdV1DTO(productPS, optionsPS);
}
