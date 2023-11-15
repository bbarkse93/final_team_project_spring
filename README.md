<p align="center">
  <img src="https://github.com/knh1766/study-dto/assets/135561378/0e9c88bc-ec01-4ac3-85f1-d700ea3a427e" alt="이미지">
</p>

# 🥕당근마켓클론코딩

# 🖐 프로젝트5조

* **박세환(팀장)**
* **성민경**
* **김나희**
* **이정완**
* **최봉준**

# 📌시연영상

## 🥕당근마켓기능화면영상

https://github.com/bbarkse93/final_team_project_spring/assets/135561378/dbe6f0c6-a87a-49a9-936e-d3af4f4d6ab8

## 📝API문서영상

https://github.com/bbarkse93/final_team_project_spring/assets/135561378/69e91098-8564-44b4-b707-cf995284b035

# ⚒️기술스택

- **Backend**
  ![js](https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
  ![js](https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
  ![js](https://img.shields.io/badge/restdoc-6DB33F?style=for-the-badge&logo=&logoColor&logoColor=white)
  ![js](https://img.shields.io/badge/JPA-6DB33F?style=for-the-badge&logo=&logoColor&logoColor=white)
  ![js](https://img.shields.io/badge/postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
  ![js](https://img.shields.io/badge/junit-25A162?style=for-the-badge&logo=junit5&logoColor&logoColor=white)


- **Frontend**
  ![js](https://img.shields.io/badge/flutter-F7DF1E?style=for-the-badge&logo=flutter&logoColor=white)
  ![js](https://img.shields.io/badge/dart-0175C2?style=for-the-badge&logo=dart&logoColor=white)


- **협업도구**
  ![js](https://img.shields.io/badge/git-FC6D26?style=for-the-badge&logo=git&logoColor=white)
  ![js](https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white)
  ![js](https://img.shields.io/badge/slack-4A154B?style=for-the-badge&logo=slack&logoColor=white)
  ![js](https://img.shields.io/badge/notion-181717?style=for-the-badge&logo=notion&logoColor=white)

- **데이터베이스**
  ![js](https://img.shields.io/badge/H2-685EA9?style=for-the-badge&logo=hugo&logoColor=white)
  ![js](https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
  ![js](https://img.shields.io/badge/firestore-C8332D?style=for-the-badge&logo=fireship&logoColor=white)

# ✍의존성

``` implementation group: 'com.auth0', name: 'java-jwt', version: '4.4.0'
    implementation 'org.springframework.boot:spring-boot-starter-aop'
    implementation 'org.springframework.boot:spring-boot-starter-validation'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    compileOnly 'org.projectlombok:lombok'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    runtimeOnly 'com.h2database:h2'
    runtimeOnly 'com.mysql:mysql-connector-j'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'org.springframework.restdocs:spring-restdocs-mockmvc'
```

# ✍당근마켓을 선택한이유?

</hr>
클론코딩 프로젝트를 시작한 이유는 전문적인 기획자와 디자이너가 없어서였습니다. <br/>UI 완성도를 향상시키기 위해 기존에 완성된 당근마켓을 선택했습니다. <br/>특히 GPS와 채팅 기능을 구현해보고 싶었는데,그러기 위해서는 채팅, 지도, 그리고 GPS와 같은 다양한 API를 활용해야 했습니다. <br/> 
당근마켓 어플은 다양한 API를 활용할 수 있는 기회라 생각했고, <br/>이를 통해 프로젝트를 더 다양하고 실제적으로 발전시킬 수 있을 것으로 생각해서 이를 선택하게 되었습니다.

# 📄모델링 연관관계

![image](https://github.com/bbarkse93/final_team_project_spring/assets/135561378/49ca4593-614a-4e08-b51f-03582f3e7e89)

# 📆일정관리

NOTION을활용한 일정정리
[노션을 활용한 일정관리](https://paper-danthus-c42.notion.site/f473120179164f3a98cfe8353d668450?v=1266b3496a8142b898bdf4cb8f3311ce&pvs=4, "노션을 활용한 일정관리")

# 아키텍쳐
* RESTful
* 리소스를 URI로 식별, HTTP 메소드를 통해 리소스를 조작
* JSON으로 표현

# DB, 인증/권한 검사

DB
* Agile기법으로 엔티티를 설계
* 주로 JPA Reoisutiry 인터페이스의 기본 메소드 사용
* 기본 메소드로 요청되지 않는 쿼리문은 JPQL(객체지향쿼리)로 요청

JWT
* 스프링 진입 전에 필터로 인증 검사
* 컨트롤러 진입 전에 인터셉터로 권한 검사
* 특정 페이지 ex)로그인 의 경우 예외적으로 접근을 허용하는 로직을 작성

Session
* JWT를 통해 필터에서 검증 후 유저정보는 session을 사용해 관리
* 메모리영역에서 세션을 사용하고 버리는 용도.
* 다시 토큰을 검증하지 않아도 됨.

# 기능설명

회원
* 로그인
* 회원가입

상품판매
* 전체 목록보기
* 상세보기
* 등록 & 수정
* 검색
* 북마크 & 북마크 해제

동네생활
* 전체 목록보기
* 상세보기
* 등록 & 수정
* 검색
* 좋아요 & 좋아요 취소

나의 정보
* 유저 정보 수정
* (동네생활) 내가 쓴 글, 댓글 조회
* 판매목록

고객 센터
* 문의하기

# 🔶보완할 점

* 세션관리와 테스트 코드 작성을 통해 기능을 시험해보고 적용하는 과정이 서툴렀다.
* riverpod의 상태관리가 아직 많이 부족하며 학습이 더 필요하다고 느꼈으며 그림은 어느 정도는그릴 수 있겠지만
  아직 세부적인 위젯의 공부가 필요하다.
* future의 문법과 snapshot의 개념을 더욱 자세히 알아보고싶다.
  정확한 개념을 아는 상태에서 프로젝트에 들어가지 못한게 너무도 아쉽다
  파이어베이스의 FCM 기능을 구현하지못했다. FCM 기능을 살려보고싶다.
  백엔드와 소통이 다소 많이 부족했던것 같다

# 🔶느낀점

* 완벽하게 완성은 못했지만 해보고 싶었던 기능을 다 사용해본 것 같아 좋았다.
  실시간으로 의견교환을 하는 것의 중요성을 매우 크게 느꼈다.
  매일 회의를 하고 잦은 의견교환으로 인해 방향이 엇나가도 다시 수정하고 진행 할 수 있었던 것같다.
  추후 시간을 들여 공부를 하면서 마무리 해봐야겠다.
* 프론트로 먼저 그린다고 끝이 나는 게아니였으며 서버에서 다 돼도 결국 바인딩하는 과정에서 오류가 많이 발생하
  였으며 결국 같이 진행하면서 현재 진행 상황을 공유하는 것이 중요하고 느꼈다.
* 소통이 중요하다.
  소통에서 비롯해서 작은것 하나하나가 틀어지면 나중에는 되돌릴수 없는 큰 결과를 가져오는것 같다.
