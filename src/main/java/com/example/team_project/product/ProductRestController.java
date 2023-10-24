package com.example.team_project.product;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductService productService;

    // 상품상세보기
    @GetMapping("/product/{id}") // (상품만조회,양방향맵핑)
    public ResponseEntity<?> FindById(@PathVariable Integer id) {
        ProductResponse.FindByIdDTO responseDTO = productService.FindById(id);
        return ResponseEntity.ok(responseDTO);
    }
}
