package com.example.team_project.product;

import lombok.RequiredArgsConstructor;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_project._core.erroes.exception.Exception404;
import com.example.team_project._core.utils.ApiUtils;
import com.example.team_project.product.product_pic.ProductPic;

@RequiredArgsConstructor
@RestController
public class ProductRestController {


    private final ProductService productService;

    // (기능1) 상품 목록보기
    @GetMapping("/products")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(ApiUtils.success(productService.findAll()));
    }
    
    
    private final ProductService productService;
    
    // 상품상세보기
    @GetMapping("/product/{id}") // (상품만조회,양방향맵핑)
    public ResponseEntity<?> FindById(@PathVariable Integer id) {
        ProductResponse.FindByIdDTO responseDTO = productService.FindById(id);
        return ResponseEntity.ok(responseDTO);
    }

}
