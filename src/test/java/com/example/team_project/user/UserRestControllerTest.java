package com.example.team_project.user;

import com.example.team_project.MyWithRestDoc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@AutoConfigureMockMvc //MockMVC띄우기
@SpringBootTest // 통합테스트 모든것을 메모리에 다 띄워짐
public class UserRestControllerTest extends MyWithRestDoc {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TEST_TOKEN = "Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtZXRhY29kaW5nLWtleSIsImlkIjoxLCJ1c2VybmFtZSI6InNzYXIiLCJleHAiOjQ4NTM0Njg0NzZ9.SlXcvYRnnwP1IJDtjd0Q0oYz56ohHiYpz5KyJBk5HmsZ-0UnvT16WQt43D0pax4hz1cVH2Gyz9sPq7jqlJH2Xg";
    private MockHttpSession httpSession;

    @BeforeEach
    public void setUp() {
        httpSession = new MockHttpSession();
        User sessionUser = User.builder().id(1).username("ssar").build();
        httpSession.setAttribute("sessionUser", sessionUser);
    }

    private User createMockUser() {
        return User.builder()
                .id(1)
                .username("ssar")
                .build();
    }

    @Test
    public void join_test() throws Exception {
        //given
        UserRequest.UserJoinReqDTO requsetDTO = new UserRequest.UserJoinReqDTO();
        requsetDTO.setEmail("ssarr@nate.com");
        requsetDTO.setPassword("1q2w3e4r!");
        requsetDTO.setLocation("부전동");
        requsetDTO.setUsername("ssarr");

        //Json으로 바꿔주는애 DTO -> JSON
        ObjectMapper om = new ObjectMapper();
        String requestBody = om.writeValueAsString(requsetDTO);

        // when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/join")
                                .content(requestBody)
                                .contentType(MediaType.APPLICATION_JSON)
                );
        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println("성공" + responseBody);

        // then
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.id").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.email").value("ssarr@nate.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.password").value(IsNull.nullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.location").value("부전동"))
                .andDo(MockMvcResultHandlers.print())
                .andDo(document);
    }

    @Test
    public void login_test() throws Exception {
        //given
        UserRequest.UserLoginReqDTO requestDTO = new UserRequest.UserLoginReqDTO();
        requestDTO.setUsername("ssar");
        requestDTO.setPassword("1q2w3e4r!");

        //Json으로 바꿔주는애 DTO -> JSON
        ObjectMapper om = new ObjectMapper();
        String requestBody = om.writeValueAsString(requestDTO);

        //when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/login")
                                .content(requestBody)
                                .contentType(MediaType.APPLICATION_JSON)
                );
        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println("성공" + responseBody);

        //then
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.userId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.username").value("ssar"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.nickname").value("쌀"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.password").value(IsNull.nullValue()))
                .andDo(MockMvcResultHandlers.print())
                .andDo(document);
    }

    @Test
    public void findUser_test() throws Exception {
        //given
        UserResponse.UserDTO responseDTO = new UserResponse.UserDTO(User.builder().id(1).build());


        //Json으로 바꿔주는애 DTO -> JSON
        ObjectMapper om = new ObjectMapper();
        String requestBody = om.writeValueAsString(responseDTO);

        //when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/users/1")
                                .header(AUTHORIZATION_HEADER, TEST_TOKEN)
                                .session(httpSession)
                                .content(requestBody)
                                .contentType(MediaType.APPLICATION_JSON)
                );
        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println("성공" + responseBody);

        //then
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.username").value("ssar"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.nickname").value("쌀"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.userPicUrl").value(".\\images\\default-profile.png"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.location").value("부전동"))
                .andDo(MockMvcResultHandlers.print())
                .andDo(document);

    }

    @Test
    public void updateUser_test() throws Exception {
        //given
        UserRequest.UserUpdateReqDTO requestDTO = new UserRequest.UserUpdateReqDTO();
        requestDTO.setPassword("asdgsdgsgsdf!");
        requestDTO.setNickname("코스");
        requestDTO.setUserPicUrl("맛있는쌀.png");

        //Json으로 바꿔주는애 DTO -> JSON
        ObjectMapper om = new ObjectMapper();
        String requestBody = om.writeValueAsString(requestDTO);

        //when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders
                                .put("/users/1")
                                .session(httpSession)
                                .content(requestBody)
                                .contentType(MediaType.APPLICATION_JSON)
                );
        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println("성공" + responseBody);

        //then
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.nickname").value("코스"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.userPicUrl").value("맛있는쌀.png"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.password").value(IsNull.nullValue()))
                .andDo(MockMvcResultHandlers.print())
                .andDo(document);
    }

    @Test
    public void myBoards_test() throws Exception {
//        // given
//        List<UserResponse.MyWriteRespDTO> responseDTO = Arrays.asList(new UserResponse.MyWriteRespDTO.WriteBoardsDTO(), new UserResponse.MyWriteRespDTO.WriteBoardsDTO());
//        // when
//        ResultActions resultActions = mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/users/myboards")
//                        .header(AUTHORIZATION_HEADER, TEST_TOKEN)
//                        .session(httpSession)
//                        .contentType(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        resultActions
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.response.boardWrites", Matchers.hasSize(2)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.response.replyWrites", Matchers.hasSize(2)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.response.boardWrites[0].id").value(1))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.response.boardWrites[0].boardTitle").value("게시물 1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.response.replyWrites[0].replyId").value(1))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.response.replyWrites[0].replyId").value(2))
//                .andDo(MockMvcResultHandlers.print())
//                .andDo(document); // 도큐먼트 생성 등의 작업 추가
    }


    @Test
    public void saleproducts_test() throws Exception {
        //given

        //Json으로 바꿔주는애 DTO -> JSON

        //when

        //then

    }
}
