package com.example.team_project.product;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.http.parser.Authorization;

import javax.el.ELException;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.team_project._core.advice.ValidAdvice;
import com.example.team_project._core.config.FilterConfig;
import com.example.team_project._core.erroes.exception.Exception400;
import com.example.team_project._core.utils.ApiUtils;
import com.example.team_project.product.ProductRequest.ProductUpdateReqDTO;
import com.example.team_project.product.product_pic.ProductPic;
import com.example.team_project.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;

// @Import({ ValidAdvice.class, FilterConfig.class })
// @WebMvcTest
@SpringBootTest
public class ProductRestControllerTest {

    @Autowired
//    MockMvc mvc;

    @MockBean
    private ProductService productService;



    @Autowired
    private ObjectMapper om;

//    @Test
//    public void findById_test() throws Exception {
//        Integer id = 3;
//        // ProductResponse.FindAllDTO.UserDTO user = new UserDTO()
//
//
//
//        User createUser = User.builder()
//        .location("양산")
//        .password("1234")
//        .email("hubh@nate.com")
//        .userPicUrl("strindfgbvqas")
//        .distinguish(false)
//        .build();
//
//
//
//
//    Product p1 = Product.builder()
//            .id(1)
//            .productName("에어랩")
//            .productDescription("혹시 머리를 길러볼까해서 미리 구매했는데 팔려구요")
//            .productPrice(350000)
//            .user(createUser)
//            .build();
//    Product p2 = Product.builder()
//            .id(2)
//            .productName("상품권 팝니다.")
//            .productDescription("신세계 상품권 10만원권 팝니다")
//            .productPrice(95000)
//            .user(createUser)
//            .build();
//    Product p3 = Product.builder()
//            .id(3)
//            .productName("아이폰 15Pro 블루티타늄 256기가")
//            .productDescription("미개봉입니다.")
//            .productPrice(1550000)
//            .user(createUser)
//            .build();
//
//            List<Product> productList = Arrays.asList(p1,p2,p3);
//
//            List<ProductResponse.FindAllDTO> responseDTOs = productList.stream()
//            .map(p -> new ProductResponse.FindAllDTO(p))
//            .collect(Collectors.toList());
//
//            // when(productService.findAll(mockito.anyInt())).thenReturn(responseDTOs);
//                when(productService.findAll()).thenReturn(responseDTOs);
//
//            ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/products").param("id", id.toString()));
//            String responseBody = actions.andReturn().getResponse().getContentAsString();
//            System.out.println("테스트 : " + responseBody);

    // // 상품 목록보기
    // @GetMapping("/products")
    // public ResponseEntity<?> findAll() {
    // return ResponseEntity.ok().body(ApiUtils.success(productService.findAll()));
    // }

    // // 상품상세보기
    // @GetMapping("/product/{id}")
    // public ResponseEntity<?> FindById(@PathVariable Integer id) {
    // ProductResponse.FindByIdDTO responseDTO = productService.FindById(id);
    // return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    // }

    // // 상품 등록
    // @PostMapping("/product/write")
    // public ResponseEntity<?> WriteProduct(@RequestBody
    // ProductRequest.ProductWriteReqDTO productWriteReqDTO) {
    // productService.saveProductWithProductPics(productWriteReqDTO);
    // return ResponseEntity.ok().body(ApiUtils.success("ok"));
    // }

    // // 상품 수정
    // @PostMapping("/product/update/{id}")
    // public ResponseEntity<?> updateProduct(@PathVariable Integer id,
    // @RequestBody ProductUpdateReqDTO productUpdateReqDTO) {
    // productService.updateProductWithProductPics(id, productUpdateReqDTO);
    // return ResponseEntity.ok().body(ApiUtils.success("ok"));
    // }
    }

