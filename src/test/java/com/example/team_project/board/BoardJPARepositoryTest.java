// package com.example.team_project.board;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import com.example.team_project.reply.Reply;
// import com.example.team_project.user.UserResponse;

// import java.util.ArrayList;
// import java.util.Optional;
// import java.util.List;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;

// @DataJpaTest
// public class BoardJPARepositoryTest {

//     @Autowired
//     private BoardJPARepository boardJPARepository;

//     @Test
//     void findbyUserId_test() {
//         List<Board> boardList = boardJPARepository.findbyUserId(1);

//         System.out.println("=====테스트=====");
//         List<UserResponse.MyWriteRespDTO.WriteBoardsDTO> responseBoardWriteDTO = boardList.stream()
//                 .distinct()
//                 .map(b -> {
//                     UserResponse.MyWriteRespDTO.WriteBoardsDTO writeDTO = new UserResponse.MyWriteRespDTO.WriteBoardsDTO(
//                             b);
//                     List<UserResponse.MyWriteRespDTO.WriteBoardsDTO.BoardPicDTO> boardPicDTO = b.getBoardPics()
//                             .isEmpty() ? null
//                                     : b.getBoardPics().stream()
//                                             .limit(1)
//                                             .map(bp -> new UserResponse.MyWriteRespDTO.WriteBoardsDTO.BoardPicDTO(bp))
//                                             .collect(Collectors.toList());
//                     writeDTO.setBoardPics(boardPicDTO);

//                     return writeDTO;
//                 })
//                 .collect(Collectors.toList());

//         // System.out.println("=====테스트=====");
//         // String p1 = product.get().getProductName();
//         // String p2 = product.get().getProductDescription();
//         // Integer p3 = product.get().getId();
//         // Integer p4 = product.get().getUser().getId();
//         // System.out.println(p1);
//         // System.out.println(p2);
//         // System.out.println(p3);
//         // System.out.println(p4);
//     }

//     // 글쓴이의 유저아이디가 일치하는 보드들 들고오기

//     // 유저아이디가 일치하는 댓글을 찾기 (보드아이디도 알수있음.)
//     // List<Reply> replyList = replyJPARepository.findbyUserId(1);

// }
