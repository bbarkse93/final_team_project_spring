package com.example.team_project.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_project._core.utils.ApiUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProductRestController {


    private final ProductService productService;


    // 상품 목록보기
    @GetMapping("/products")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(ApiUtils.success(productService.findAll()));
    }
    
    // 상품상세보기
    @GetMapping("/products/{id}")
    public ResponseEntity<?> FindById(@PathVariable Integer id) {
        ProductResponse.FindByIdDTO responseDTO = productService.FindById(id);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 상품 등록
    @PostMapping("/products/write")
    public ResponseEntity<?> WriteProduct(@RequestBody ProductRequest.ProductRequestDTO productRequestDTO){
        ProductResponse.WriteRespDTO responseDTO =  productService.saveProductWithProductPics(productRequestDTO);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }
  
}

