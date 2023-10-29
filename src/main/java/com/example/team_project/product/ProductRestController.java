package com.example.team_project.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_project._core.utils.ApiUtils;
import com.example.team_project.product.ProductRequest.ProductUpdateReqDTO;

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
    @GetMapping("/product/{id}")
    public ResponseEntity<?> FindById(@PathVariable Integer id) {
        ProductResponse.FindByIdDTO responseDTO = productService.FindById(id);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 상품 등록
    @PostMapping("/product/write")
    public ResponseEntity<?> WriteProduct(@RequestBody ProductRequest.ProductWriteReqDTO productWriteReqDTO) {
        productService.saveProductWithProductPics(productWriteReqDTO);        
        // responseDTO = productService.FindById(productWriteReqDTO.get);
        return ResponseEntity.ok().body(ApiUtils.success("ok"));
    }

    // 상품 수정
    @PostMapping("/product/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id,
            @RequestBody ProductUpdateReqDTO productUpdateReqDTO) {
        productService.updateProductWithProductPics(id, productUpdateReqDTO);
        return ResponseEntity.ok().body(ApiUtils.success("ok"));
    }

    // 상품 삭제
    // @PostMapping("/productDelete/{id}")
    // public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
    // try {
    // productService.deleteProduct(id);
    // return ResponseEntity.ok().body(ApiUtils.success("ok"));
    // } catch (Exception e) {
    // return new ResponseEntity<>("게시글 삭제 실패", HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }
}
