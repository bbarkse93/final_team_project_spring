package com.example.team_project.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductJPARepository extends JpaRepository<Product, Object> {

    @Modifying
    @Query("UPDATE Product p SET p.productPrice = :productPrice, p.productDescription = :productDescription, p.productName = :productName WHERE p.id = :productId")
    void mUpdateProduct(@Param("productId") int productId, @Param("productPrice") int productPrice, @Param("productDescription") String productDescription, @Param("productName") String productName);

    @Query("SELECT p FROM Product p WHERE p.id = :productId")
    Product findProductById(@Param("productId") int productId);

    
}

