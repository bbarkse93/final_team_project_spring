package com.example.team_project.product.product_book_mark;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;

public interface ProductBookmarkJPARepository extends JpaRepository<ProductBookmark, Integer> {

    @Modifying
    @Query(value = "INSERT INTO product_bookmark_tb (`id`, `product_id`,`user_id`) VALUES (:Id, :productId,:userId)", nativeQuery = true)
    int mSave(@Param("Id") Integer Id, @Param("productId") Integer productId, @Param("userId") Integer userId);

    @DeleteMapping
    @Query(value = "delete from product_like_tb where product_id = :productId and user_id = :userId", nativeQuery = true)
    int mDelete(@Param("productId") Integer productId, @Param("userId") Integer userId);
}
