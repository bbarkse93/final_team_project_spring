package com.example.team_project.product;

import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@DataJpaTest
public class ProductJPARepositoryTest {

    @Autowired
    private ProductJPARepository productJPARepository;

    // @Test
    // public void findById_test() throws JsonProcessingException {
    // ObjectMapper om = new ObjectMapper();

    // Optional<Product> product = productJPARepository.findById(1);
    // String json = om.writeValueAsString(product);
    // System.out.println("테스트 : " + json);

    // }

    @Test
    public void findById_test() {
        Optional<Product> product = productJPARepository.findById(3);

        System.out.println("=====테스트=====");
        String p1 = product.get().getProductName();
        String p2 = product.get().getProductDescription();
        Integer p3 = product.get().getId();
        Integer p4 = product.get().getUser().getId();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

    }

    // @Transactional
    // public void updateProductWithProductPics(Integer id, ProductUpdateReqDTO
    // productUpdateReqDTO) {
    // Product product = productJPARepository.findById(id)
    // .orElseThrow(() -> new Exception404("게시글을 찾을 수 없습니다. " + id));
    // System.out.println("TEST" + product.getId());
    // // Product productup =
    // productJPARepository.save(productUpdateReqDTO.toEntity());
    // // ProductUpdateReqDTO productup = product.get();
    // // productup.setProductName(productUpdateReqDTO.getProductName());

    // // 하나씩
    // product.setProductName(productUpdateReqDTO.getProductName());
    // product.setProductDescription(productUpdateReqDTO.getProductDescription());
    // product.setProductPrice(productUpdateReqDTO.getProductPrice());

    // // product.product(productUpdateReqDTO.getProductName());

    // // 한방에
    // // Product.setUpdate(
    // // productUpdateReqDTO.getProductName(),
    // // productUpdateReqDTO.getProductDescription(),
    // // productUpdateReqDTO.getProductPrice());

    // // productJPARepository.save(product);
    // List<ProductPic> productPics = productUpdateReqDTO.getProductPics();

    // for (ProductPic productPic : productPics) {
    // System.out.println(productPic.getProductPicUrl());
    // productPicJPARepository.save(productPic);
    // }
}
