INSERT INTO user_tb (`id`,`username`, `password`, `email`, `user_pic_url`, `location`, `distinguish`, `user_created_at`) VALUES (1, 'ssar', '12345678', 'ssar@nate.com', 'ssar_profile.png', '부전동', true, NOW());
INSERT INTO user_tb (`id`,`username`, `password`, `email`, `user_pic_url`, `location`, `distinguish`, `user_created_at`) VALUES (2, 'cos', '12345678', 'cos@nate.com', 'cos_profile.png', '전포동', true, NOW());

INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`) VALUES (1, '다이슨 에어랩', '혹시 머리를 길러볼까해서 미리 구매했는데 팔려구요', 350000, NOW(), 1);
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`) VALUES (2, '상품권 팝니다.', '신세계 상품권 10만원권 팝니다', 95000, NOW(), 1);
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`) VALUES (3, '아이폰 15Pro 블루티타늄 256기가', '미개봉입니다.', 1550000, NOW(), 2);
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`) VALUES (4, '그림컴퓨터아카데미 컴퓨터', '몰래 팔아요. 사용감 있어요', 4560000, NOW(), 2);

INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (1, '드라이기 사진', 1);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (2, '드라이기 사진', 1);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (3, '드라이기 사진', 1);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (4, '상품권 사진', 2);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (5, '아이폰 사진', 3);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (6, '아이폰 사진', 3);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (7, '아이폰 사진', 3);
