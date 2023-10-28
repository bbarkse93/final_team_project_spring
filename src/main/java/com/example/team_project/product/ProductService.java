package com.example.team_project.product;

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

    // 상품 리스트
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
    public ProductResponse.WriteRespDTO saveProductWithProductPics(ProductRequest.ProductRequestDTO productRequestDTO) {
        Product product = productJPARepository.save(productRequestDTO.toEntity());
        List<ProductPic> productPics = productRequestDTO.getProductPics();

        for (ProductPic productPic : productPics) {
            productPic.setProduct(product);
           productPicJPARepository.save(productPic);
        }

        List<ProductPic> productPicList = productPicJPARepository.findByProductId(product.getId());

        return new ProductResponse.WriteRespDTO(product, productPicList);
    }
}