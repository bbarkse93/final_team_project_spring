package com.example.team_project.product;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.team_project._core.erroes.exception.Exception404;
import com.example.team_project.product.ProductRequest.ProductUpdateReqDTO;
import com.example.team_project.product.product_pic.ProductPic;
import com.example.team_project.product.product_pic.ProductPicJPARepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductJPARepository productJPARepository;
    private final ProductPicJPARepository productPicJPARepository;

    // 상품 목록보기
    public List<ProductResponse.FindAllDTO> findAll() {
        List<Product> dtos = productJPARepository.findAll();

        List<ProductResponse.FindAllDTO> responseDTO = dtos.stream()
                .map(t -> new ProductResponse.FindAllDTO(t))
                .collect(Collectors.toList());

        return responseDTO;
    }

    // 상품 상세보기
    public ProductResponse.FindByIdDTO FindById(Integer id) {

        Product product = productJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("상품을 찾을 수 없습니다. ID: " + id));

        List<ProductPic> productPic = productPicJPARepository.findByProductId(product.getId());

        return new ProductResponse.FindByIdDTO(product, productPic);
    }

    // 상품 등록
    @Transactional
    public void saveProductWithProductPics(ProductRequest.ProductWriteReqDTO productWriteReqDTO) {
        Product product = productJPARepository.save(productWriteReqDTO.toEntity());
        List<ProductPic> productPics = productWriteReqDTO.getProductPics();

        for (ProductPic productPic : productPics) {
            System.out.println(productPic.getProductPicUrl());
            productPicJPARepository.save(productPic);
        }
    }

    // 상품 수정
    @Transactional
    public void updateProductWithProductPics(Integer id, ProductUpdateReqDTO productUpdateReqDTO) {
        Product product = productJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("게시글을 찾을 수 없습니다. " + id));

        productJPARepository.updateProduct(
                product.getId(),
                productUpdateReqDTO.getProductPrice(),
                productUpdateReqDTO.getProductDescription(),
                productUpdateReqDTO.getProductName());

        // 하나씩
        // product.setProductName(productUpdateReqDTO.getProductName());
        // product.setProductDescription(productUpdateReqDTO.getProductDescription());
        // product.setProductPrice(productUpdateReqDTO.getProductPrice());

        // 한방에
        // product.setUpdate(
        // productUpdateReqDTO.getProductName(),
        // productUpdateReqDTO.getProductDescription(),
        // productUpdateReqDTO.getProductPrice());

        List<ProductPic> productPics = productUpdateReqDTO.getProductPics();

        for (ProductPic productPic : productPics) {
            System.out.println(productPic.getProductPicUrl());
            // productPicJPARepository.updateProductPic(productPic);
            productPicJPARepository.updateProductPic(product.getId(),
            productPic.getProductPicUrl());
        }
    }
}

// @Transactional
// public void deleteProduct(int productId) {
// // 먼저 해당 게시글의 이미지를 삭제
// List<ProductPic> productPics =
// productPicJPARepository.findByProduct_Id(productId);
// for (ProductPic productPic : productPics) {
// productPicJPARepository.delete(productPic);
// }

// // 그 다음 게시글을 삭제
// productJPARepository.deleteById(productId);
// }
// }
