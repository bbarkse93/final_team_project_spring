package com.example.team_project.product;

import java.util.List;
import java.util.stream.Collectors;

import com.example.team_project.board.BoardResponse;
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
    public List<ProductResponse.ProductListRespDTO> findAll() {
        List<Product> dtos = productJPARepository.findAll();

        List<ProductResponse.ProductListRespDTO> responseDTO = dtos.stream()
                .distinct()
                .map(p ->{
                    ProductResponse.ProductListRespDTO productDTO = new ProductResponse.ProductListRespDTO(p);
                    List<ProductResponse.ProductListRespDTO.ProductPicDTO> productPicDTOs =
                            p.getProductPics().isEmpty() ? null : p.getProductPics().stream()
                            .limit(1)
                            .map(pp -> new ProductResponse.ProductListRespDTO.ProductPicDTO(pp))
                            .collect(Collectors.toList());
                    productDTO.setProductPics((productPicDTOs));
                    return productDTO;
                })
                .collect(Collectors.toList());

        return responseDTO;
    }

    // 상품 상세보기
    public ProductResponse.ProductDetailRespDTO FindById(Integer id) {

        Product product = productJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("상품을 찾을 수 없습니다. ID: " + id));

        List<ProductPic> productPic = productPicJPARepository.findByProductId(product.getId());

        return new ProductResponse.ProductDetailRespDTO(product, productPic);
    }

    // 상품 등록
    @Transactional
    public ProductResponse.ProductWriteRespDTO saveProductWithProductPics(ProductRequest.ProductWriteReqDTO productWriteReqDTO) {
        Product product = productJPARepository.save(productWriteReqDTO.toEntity());
        List<ProductPic> productPics = productWriteReqDTO.getProductPics();

        for (ProductPic productPic : productPics) {
            productPic.setProduct(product);
           productPicJPARepository.save(productPic);
        }

        List<ProductPic> productPicList = productPicJPARepository.findByProductId(product.getId());

        return new ProductResponse.ProductWriteRespDTO(product, productPicList);
    }
}