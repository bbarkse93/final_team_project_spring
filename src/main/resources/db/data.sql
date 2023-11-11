-- Category 코드 테이블
INSERT INTO board_category_tb (`id`, `category`) VALUES (1, '동네맛집');
INSERT INTO board_category_tb (`id`, `category`) VALUES (2, '동네질문');
INSERT INTO board_category_tb (`id`, `category`) VALUES (3, '동네소식');
INSERT INTO board_category_tb (`id`, `category`) VALUES (4, '생활정보');
INSERT INTO board_category_tb (`id`, `category`) VALUES (5, '취미생활');

-- User 정보
INSERT INTO user_tb (`id`,`username`, `password`, `email`, `nickname`, `user_pic_url`, `location`, `distinguish`, `user_created_at`) VALUES (1, 'ssar', '1q2w3e4r!', 'ssar@nate.com', '쌀', '.\images\default-profile.png', '부전동', true, NOW());
INSERT INTO user_tb (`id`,`username`, `password`, `email`, `nickname`, `user_pic_url`, `location`, `distinguish`, `user_created_at`) VALUES (2, 'cos', '1q2w3e4r!', 'cos@nate.com', '코스',  '.\images\default-profile.png', '전포동', true, NOW());


-- Product 정보
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (1, '다이슨 에어랩', '혹시 머리를 길러볼까해서 미리 구매했는데 팔려구요', 350000, NOW(), 1, 'true');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (2, '상품권 팝니다.', '신세계 상품권 10만원권 팝니다', 95000, NOW(), 1, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (3, '아이폰 15Pro 블루티타늄 256기가', '미개봉입니다.', 1550000, NOW(), 2, 'true');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (4, '그림컴퓨터아카데미 컴퓨터', '몰래 팔아요. 사용감 있어요', 4560000, NOW(), 2, 'false');

-- Product 사진
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (1, '.\images\드라이기_9b9b9028-7697-453c-917a-398378c0f02b.png', 1);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (2, '.\images\드라이기_1e05f7c3-c2ae-4d2a-b07b-713971223de1.png', 1);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (3, '.\images\드라이기_6012592b-ee4d-42e5-9724-772a17018415.png', 1);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (4, '.\images\상품권_4b590887-5a05-409d-a107-f8a38cbea64e.png', 2);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (5, '.\images\아이폰15_2491dcfb-7d5f-48ad-a30e-21196a0608d4.png', 3);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (6, '.\images\아이폰15_a894715a-110e-4c53-9faf-06f490c8772d.png', 3);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (7, '.\images\아이폰15_c05a8fbe-2ab4-48a8-bf0a-1949a26d7f16.png', 3);

-- Board 정보
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (1, '날씨가 좋네용', '산책하기 딱인듯', NOW(), 1, 1);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (2, '꽃이 이쁨', '절 닮은듯', NOW(), 1, 2);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (3, '길냥이 발견', '이리오너라', NOW(), 2, 3);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (4, '아침 지하철', '지옥 그자체', NOW(), 2, 4);

-- Board 사진
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (1, '.\images\날씨_0fb15a92-cea9-43e4-9703-7c6f44876214.png', 1);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (2, '.\images\날씨_06756463-7503-4150-828a-698981f1ad92.png', 1);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (4, '.\images\들꽃_733b3169-1d6d-4d79-a591-02dd326dbcfb.png', 2);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (5, '.\images\길냥이_6012592b-ee4d-42e5-9724-772a17018415.png', 3);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (6, '.\images\길냥이_b82132d8-7d0d-4e91-b4aa-6df63fc7009c.png', 3);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (7, '.\images\길냥이_76700472-1c21-4442-9aaf-206757f73a9f.png', 3);

-- Reply 등록
INSERT INTO reply_tb (`id`, `comment`, `reply_created_at`, `board_id`, `user_id`) VALUES (1, '댓글 1',NOW(), 1, 2);
INSERT INTO reply_tb (`id`, `comment`, `reply_created_at`, `board_id`, `user_id`) VALUES (2, '댓글 2',NOW(), 1, 1);

-- Product 북마크
INSERT INTO product_bookmark_tb (`id`, `product_id`, `user_id`) VALUES (1, 1, 1);
INSERT INTO product_bookmark_tb (`id`, `product_id`, `user_id`) VALUES (2, 1, 2);
INSERT INTO product_bookmark_tb (`id`, `product_id`, `user_id`) VALUES (3, 2, 1);
INSERT INTO product_bookmark_tb (`id`, `product_id`, `user_id`) VALUES (4, 3, 2);

-- Board 좋아요
INSERT INTO board_like_tb (`id`, `board_id`, `user_id`) VALUES (1, 1, 1);
INSERT INTO board_like_tb (`id`, `board_id`, `user_id`) VALUES (2, 1, 2);
INSERT INTO board_like_tb (`id`, `board_id`, `user_id`) VALUES (3, 2, 1);
INSERT INTO board_like_tb (`id`, `board_id`, `user_id`) VALUES (4, 2, 2);
INSERT INTO board_like_tb (`id`, `board_id`, `user_id`) VALUES (5, 3, 1);

-- reply 좋아요
INSERT INTO reply_like_tb (`id`, `reply_id`, `user_id`) VALUES (1, 1, 1);
INSERT INTO reply_like_tb (`id`, `reply_id`, `user_id`) VALUES (2, 1, 2);
INSERT INTO reply_like_tb (`id`, `reply_id`, `user_id`) VALUES (3, 2, 1);
INSERT INTO reply_like_tb (`id`, `reply_id`, `user_id`) VALUES (4, 2, 2);

--customer 문의
INSERT INTO customer_tb (`id`, `title`, `content`,`user_id`) VALUES (1, '제목1', '내용1', 1);
INSERT INTO customer_tb (`id`, `title`, `content`,`user_id`) VALUES (2, '제목2', '내용2', 1);
INSERT INTO customer_tb (`id`, `title`, `content`,`user_id`) VALUES (3, '제목3', '내용3', 2);




