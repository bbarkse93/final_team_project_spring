package com.example.team_project.product.product_pic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.team_project.product.Product;

public interface ProductPicJPARepository extends JpaRepository<ProductPic, Integer> {

    @Query(value = "select p from ProductPic p where p.product.id = :id")
    List<ProductPic> findByProductId(@Param("id") Integer id);

    @Modifying
    @Query("UPDATE ProductPic p SET p.productPicUrl = :productPicUrl WHERE p.product.id = :id")
    int updateProductPic(@Param("id") int id, @Param("productPicUrl") String productPicUrl);

    @Query("SELECT p FROM ProductPic p WHERE p.product.id = :id")
    Product findProductById(@Param("id") int id);

}
