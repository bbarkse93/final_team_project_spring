package com.example.team_project.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_project._core.utils.ApiUtils;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductRestController {


    private final ProductService productService;


    // 상품 목록보기
    @GetMapping("/products")
    public ResponseEntity<?> ProductList() {
        List<ProductResponse.ProductListRespDTO> responseDTO = productService.findAll();
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }
    
    // 상품상세보기
    @GetMapping("/products/{id}")
    public ResponseEntity<?> ProductDetail(@PathVariable Integer id) {
        ProductResponse.ProductDetailRespDTO responseDTO = productService.FindById(id);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 상품 등록
    @PostMapping("/products/write")
    public ResponseEntity<?> WriteProduct(@RequestBody ProductRequest.ProductWriteReqDTO productWriteReqDTO){
        ProductResponse.ProductWriteRespDTO responseDTO =  productService.saveProductWithProductPics(productWriteReqDTO);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }
  
}

