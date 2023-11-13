 package com.example.team_project.user;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.boot.test.mock.mockito.MockBean;
 import org.springframework.test.web.servlet.MockMvc;

 import java.util.List;

 @AutoConfigureRestDocs(uriScheme = "http", uriHost = "localhost", uriPort = 8080)
 @SpringBootTest
 public class UserRestControllerTest {

     @Autowired
     MockMvc mvc;

     @MockBean
     private UserService userService;

     // 내가 쓴글, 댓글 조회
     // 나의 당근 - 동네생활 내가 쓴글, 댓글
     public List<UserResponse.MyWriteRespDTO> myboards(int id) {
         // // 글쓴이의 유저아이디가 일치하는 보드들 들고오기
         // List<Board> boardList = boardJPARepository.findbyUserId(1);

         // // 내가 쓴글 스트림
         // List<UserResponse.MyWriteRespDTO.WriteBoardsDTO> responseBoardWriteDTO =
         // boardList.stream()
         // .distinct()
         // .map(b -> {
         // UserResponse.MyWriteRespDTO.WriteBoardsDTO writeDTO = new
         // UserResponse.MyWriteRespDTO.WriteBoardsDTO(
         // b);
         // List<UserResponse.MyWriteRespDTO.WriteBoardsDTO.BoardPicDTO> boardPicDTO =
         // b.getBoardPics()
         // .isEmpty() ? null
         // : b.getBoardPics().stream()
         // .limit(1)
         // .map(bp -> new UserResponse.MyWriteRespDTO.WriteBoardsDTO.BoardPicDTO(bp))
         // .collect(Collectors.toList());
         // writeDTO.setBoardPics(boardPicDTO);

         // return writeDTO;
         // })
         // .collect(Collectors.toList());

         // // 1. 유저아이디가 일치하는 댓글을 찾기 (보드아이디도 알수있음.)
         // List<Reply> replyList = replyJPARepository.findbyUserId(1);

         // List<UserResponse.MyWriteRespDTO.WriteBoardsDTO> responseRDTO =
         // replyList.stream()
         // .map(r -> new UserResponse.MyWriteRespDTO.WriteBoardsDTO(r.getBoard()))
         // .collect(Collectors.toList());

         // // 글쓴이의 유저아이디가 일치하는 보드들 들고오기
         // List<Board> boardList = boardJPARepository.findbyUserId(1);
         // // 유저아이디가 일치하는 댓글을 찾기 (보드아이디도 알수있음.)
         // List<Reply> replyList = replyJPARepository.findbyUserId(1);

         // // 내가 쓴글 스트림
         // List<UserResponse.MyWriteRespDTO.WriteBoardsDTO> responseBoardWriteDTO = boardList.stream()
         //         .distinct()
         //         .map(b -> {
         //             UserResponse.MyWriteRespDTO.WriteBoardsDTO writeDTO = new UserResponse.MyWriteRespDTO.WriteBoardsDTO(
         //                     b);
         //             List<UserResponse.MyWriteRespDTO.WriteBoardsDTO.BoardPicDTO> boardPicDTO = b.getBoardPics()
         //                     .isEmpty() ? null
         //                             : b.getBoardPics().stream()
         //                                     .limit(1)
         //                                     .map(bp -> new UserResponse.MyWriteRespDTO.WriteBoardsDTO.BoardPicDTO(bp))
         //                                     .collect(Collectors.toList());
         //             writeDTO.setBoardPics(boardPicDTO);

         //             return writeDTO;
         //         })
         //         .collect(Collectors.toList());

         // List<UserResponse.MyWriteRespDTO.WriteBoardsDTO> responseRDTO = replyList.stream()
         //         .map(r -> new UserResponse.MyWriteRespDTO.WriteBoardsDTO(r.getBoard()))
         //         .collect(Collectors.toList());

         // List<UserResponse.MyWriteRespDTO> responseDTO = Stream
         // .concat(responseBoardWriteDTO.stream(), responseRDTO.stream())
         // .collect(Collectors.toList());

         // List<UserResponse.MyWriteRespDTO> responseDTO = new
         // ArrayList<>(responseBoardWriteDTO);
         // responseDTO.addAll(responseRDTO);

         return null;
     }

 }
