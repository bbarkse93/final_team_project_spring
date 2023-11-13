-- Category 코드 테이블
INSERT INTO board_category_tb (`id`, `category`) VALUES (1, '동네맛집');
INSERT INTO board_category_tb (`id`, `category`) VALUES (2, '동네질문');
INSERT INTO board_category_tb (`id`, `category`) VALUES (3, '동네소식');
INSERT INTO board_category_tb (`id`, `category`) VALUES (4, '생활정보');
INSERT INTO board_category_tb (`id`, `category`) VALUES (5, '취미생활');

-- User 정보
INSERT INTO user_tb (`id`,`username`, `password`, `email`, `nickname`, `user_pic_url`, `location`, `distinguish`, `user_created_at`) VALUES (1, 'ssar', '1q2w3e4r!', 'ssar@nate.com', '쌀', 'ssar_profile.png', '부전동', true, NOW());
INSERT INTO user_tb (`id`,`username`, `password`, `email`, `nickname`, `user_pic_url`, `location`, `distinguish`, `user_created_at`) VALUES (2, 'cos', '1q2w3e4r!', 'cos@nate.com', '코스',  'cos_profile.png', '전포동', true, NOW());
INSERT INTO user_tb (`id`,`username`, `password`, `email`, `nickname`, `user_pic_url`, `location`, `distinguish`, `user_created_at`) VALUES (3, 'love', '1q2w3e4r!', 'love@nate.com', 'fjqm',  'lovw_profile.png', '연산동', true, NOW());

-- Product 정보
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (1, '다이슨 에어랩', '혹시 머리를 길러볼까해서 미리 구매했는데 팔려구요', 350000, NOW(), 1, 'true');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (2, '상품권 팝니다.', '신세계 상품권 10만원권 팝니다', 95000, NOW(), 1, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (3, '아이폰 15Pro 블루티타늄 256기가', '미개봉입니다.', 1550000, NOW(), 2, 'true');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (4, '냉장고팔아요', '1년사용했어요 이사가면서팝니다.', 2560000, NOW(), 2, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (5, '속커텐팝니다', '새거에요.', 20000, NOW(), 2, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (6, '쇼파 급처분', '1년사용했어요 이사가면서팝니다.', 70000, NOW(), 2, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (7, '전자레인지 싸게 가져가실분', '2년사용했어요 이사가면서팝니다.', 45000, NOW(), 2, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (8, '1인쇼파', '새거에요.', 70000, NOW(), 2, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (9, '러그', '한번사용했는데 깨끗해요.', 20000, NOW(), 2, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (10, '목걸이', '목걸이 선물받았는데 급처분할께요.', 120000, NOW(), 2, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (11, '반지', '사진말고도 여러개 더있어요 채팅주세요.', 50000, NOW(), 2, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (12, '애플워치 팝니다', '케이스도 같이드릴께요.', 220000, NOW(), 2, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (13, '에어팟 2번사용했어요', '거의새거에요.', 300000, NOW(), 2, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (14, '의자 판매', '2개더있어요 채팅주세요 개당 3만원입니다.', 30000, NOW(), 2, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (15, '정수기판매합니다', '사용감있어요.', 150000, NOW(), 2, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (16, '침대', '새거에요.', 200000, NOW(), 2, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (17, '커피머신 판매 폐업해서 싸게 드립니다', '폐업해서 싸게 드립니다.', 1000000, NOW(), 2, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (18, '팔찌', '24k입니다.', 1000000, NOW(), 2, 'false');
INSERT INTO product_tb (`id`,`product_name`, `product_description`, `product_price`, `product_created_at`, `user_id`, `sale_status`) VALUES (19, '화분분양해가실분', '제 아이들이라 생각하고 정성껏키웠습니다문의주세요.', 200000, NOW(), 2, 'false');



-- Product 사진
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (1, '.\images\드라이기_9b9b9028-7697-453c-917a-398378c0f02b.png', 1);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (2, '.\images\드라이기_1e05f7c3-c2ae-4d2a-b07b-713971223de1.png', 1);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (3, '.\images\드라이기_6012592b-ee4d-42e5-9724-772a17018415.png', 1);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (4, '.\images\상품권_4b590887-5a05-409d-a107-f8a38cbea64e.png', 2);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (5, '.\images\아이폰15_2491dcfb-7d5f-48ad-a30e-21196a0608d4.png', 3);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (6, '.\images\아이폰15_a894715a-110e-4c53-9faf-06f490c8772d.png', 3);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (7, '.\images\아이폰15_c05a8fbe-2ab4-48a8-bf0a-1949a26d7f16.png', 3);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (8, '.\images\냉장고_1bcc0b65-afd9-4d33-bf9d-e062f56a48a6.png', 4);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (9, '.\images\속커텐_4f94cbd6-510b-4130-a3ed-6e5028d53905.png', 5);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (10, '.\images\쇼파_36b3a49f-efeb-4384-acd5-af47747285db.png', 6);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (11, '.\images\전자레인지_5d7ce9a4-4bc5-4071-bc90-357e02e4577c.png', 7);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (12, '.\images\1인쇼파_d84d7716-d263-43d7-bde2-92485caeb1eb.png', 8);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (13, '.\images\러그_a011b88b-7c77-4cdc-8672-fc0399d10d5c.png', 9);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (14, '.\images\목걸이_45f123c4-3bbb-4b73-9173-09b8dd9a29fb.png', 10);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (15, '.\images\반지_69ab634c-b453-441f-b35a-83e375957c25.png', 11);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (16, '.\images\애플워치_34934d29-08bb-4eb4-9a42-f1c5291fa90c.png', 12);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (17, '.\images\에어팟_c28537fe-b50c-4b74-984a-8f910b5dae38.png', 13);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (18, '.\images\의자_53ff0aa5-13ba-4ea1-a5e2-618f4970b1d6.png', 14);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (19, '.\images\정수기-4a76-408e-9585-00cc53b9888b.png', 15);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (20, '.\images\침대_ca665579-7459-4168-9091-2a4699e0fdb8.png', 16);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (21, '.\images\커피머신_83051462-82a1-40bc-8c27-60ede979fd8f.png', 17);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (22, '.\images\팔찌_72f6312c-cdf2-4b5c-91c5-b67b71a17f6e.png', 18);
INSERT INTO product_pic_tb (`id`,`product_pic_url`, `product_id`) VALUES (23, '.\images\화분_83eebf52-5a9f-4cd8-8ee6-c66181db41cd.png', 19);






-- Board 정보
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (1, '날씨가 좋네용', '산책하기 딱인듯', NOW(), 1, 1);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (2, '꽃이 이쁨', '절 닮은듯', NOW(), 1, 2);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (3, '길냥이 발견', '이리오너라', NOW(), 2, 3);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (4, '아침 지하철', '지옥 그자체', NOW(), 2, 4);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (5, '너무추워요', '요즘날씨너무 추워요 집에만있고싶어요', NOW(), 2, 4);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (6, '김치찌개 맛집', '여기 김치찌개맛집이네여', NOW(), 2, 1);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (7, '눈와요', '눈와서 눈사람만들엇어용', NOW(), 2, 4);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (8, '눈썹반영구어디잘하나요?', '사진처럼하고싶어요 추천해주세요', NOW(), 2, 4);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (9, '붕어빵어디파나요?', '붕세권어딘가요?', NOW(), 2, 1);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (10, '피자맛집추천해주세요', '피자집어디가맛잇나요?', NOW(), 2, 1);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (11, '치킨먹고싶어요', '치킨브랜드추천해주세요', NOW(), 3, 1);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (12, '배드민턴치실분', '모집합니다', NOW(), 2, 5);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (13, '같이산책해요', '저녁에 같이 산책하신분', NOW(), 3, 4);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (14, '파스타잘하죠?', '제가만들었어요 자랑글입니다.', NOW(), 2, 4);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (14, '축구하자', '같이축구하실분', NOW(), 2, 5);
INSERT INTO board_tb (`id`, `board_title`, `board_content`, `board_created_at`, `user_id`, `board_category_id`) VALUES (15, '지금공사하나요?', '지금어디공사하고있나요?', NOW(), 3, 4);


-- Board 사진
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (1, '.\images\날씨_0fb15a92-cea9-43e4-9703-7c6f44876214.png', 1);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (2, '.\images\날씨_06756463-7503-4150-828a-698981f1ad92.png', 1);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (4, '.\images\들꽃_733b3169-1d6d-4d79-a591-02dd326dbcfb.png', 2);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (5, '.\images\길냥이_6012592b-ee4d-42e5-9724-772a17018415.png', 3);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (6, '.\images\길냥이_b82132d8-7d0d-4e91-b4aa-6df63fc7009c.png', 3);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (7, '.\images\길냥이_76700472-1c21-4442-9aaf-206757f73a9f.png', 3);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (8, '.\images\김치찌개_277d5b41-ec0a-4ea7-a129-9da7a4e94cec.png', 6);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (9, '.\images\눈사람_2225fcaf-eab4-4026-ab1e-0dc3f265954a.png', 7);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (10, '.\images\눈썹반영구_4f53ea2c-bdb1-46d3-a3c1-c30438c93014.png', 8);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (11, '.\images\붕세권_6364ad08-7ece-415f-be8b-f4873786c833.png', 9);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (12, '.\images\파스타_a6c90e22-eeb8-4510-a8b2-9484873ce8a7.png', 14);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (13, '.\images\배드민턴_47dc0b43-8c07-4aa0-888f-000959dff075.png', 12);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (14, '.\images\산책_7d5a1e5c-439c-4a90-b421-30a8114d510c.png', 13);
INSERT INTO board_pic_tb (`id`,`board_pic_url`, `board_id`) VALUES (15, '.\images\축구_45a448c9-6c49-4f3e-9579-07c11b3846a8.png', 14);

-- Reply 등록
INSERT INTO reply_tb (`id`, `comment`, `reply_created_at`, `board_id`, `user_id`) VALUES (1, '날씨좋네요!!',NOW(), 1, 2);
INSERT INTO reply_tb (`id`, `comment`, `reply_created_at`, `board_id`, `user_id`) VALUES (2, '여긴어딘가요?',NOW(), 1, 1);

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
INSERT INTO customer_tb (`id`, `title`, `content`,`user_id`) VALUES (1, '닉네임바꿀수있나요?', '닉네임 어떻게 바꾸나요?', 1);
INSERT INTO customer_tb (`id`, `title`, `content`,`user_id`) VALUES (2, '화면이 너무 작게나오는거같아요', '잘못설정했는지 화면이 작게나오네요', 1);
INSERT INTO customer_tb (`id`, `title`, `content`,`user_id`) VALUES (3, '비밀번호를 못찾겠어요', '이메일이 바껴서 비밀번호 못찾앗어요 그래서 다시 가입햇어요 해결해주세요', 2);




