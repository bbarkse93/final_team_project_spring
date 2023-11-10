// package com.example.team_project.product;

// import com.example.team_project.product.Product;
// import com.example.team_project.product.ProductService;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// @SpringBootTest
// public class SaleStatusAdviceTest {

//     @Autowired
//     private ProductService productService;


//     @Test
//     public void testSaleStatusAspect() {
//         // Given
//         Product product = new Product();
//         product.setStatus(1); // 판매 중

//         // When
//         productService.save(product); // ProductService의 메서드 호출 (Aspect가 적용될 것)

//         // Then
//         assertEquals("판매중", product.getSaleStatus());
//     }
// }
