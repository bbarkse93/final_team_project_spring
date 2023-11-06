package com.example.team_project.product.product_book_mark;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductBookMarkJPARepository extends JpaRepository<ProductBookMark, Integer> {

    @Modifying
    @Query(value = "INSERT INTO product_bookmark_tb (`id`, `product_id`,`user_id`) VALUES (:Id, :productId,:userId)", nativeQuery = true)
    int mSave(@Param("Id") Integer Id, @Param("productId") Integer productId, @Param("userId") Integer userId);

}
