package com.example.team_project.product;

import lombok.RequiredArgsConstructor;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.team_project._core.erroes.exception.Exception404;
import com.example.team_project._core.utils.ApiUtils;
import com.example.team_project.product.product_pic.ProductPic;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class ProductRestController {


    private final ProductService productService;

    // (기능1) 상품 목록보기
    @GetMapping("/products")
    public ResponseEntity<?> findAll() {
        ProductResponse.FindAllDTO responseDTO = productService.findAll();
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }
    
    // 상품상세보기
    @GetMapping("/product/{id}")
    public ResponseEntity<?> FindById(@PathVariable Integer id) {
        ProductResponse.FindByIdDTO responseDTO = productService.FindById(id);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }


    @PostMapping("/product/write")
    public ResponseEntity<?> WriteProduct(@RequestBody ProductRequest.ProductRequestDTO productRequestDTO){
        ProductResponse.WriteRespDTO responseDTO =  productService.saveProductWithProductPics(productRequestDTO);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }
}
