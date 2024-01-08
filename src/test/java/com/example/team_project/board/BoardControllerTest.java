package com.example.team_project.board;

import com.example.team_project.MyWithRestDoc;
import com.example.team_project._core.config.FilterConfig;
import com.example.team_project._core.filter.JwtAuthorizationFilter;
import com.example.team_project.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.http.parser.Authorization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

@AutoConfigureRestDocs(uriScheme = "http", uriHost = "localhost", uriPort = 8080)
@Import(FilterConfig.class)
@SpringBootTest//통합테스트
public class BoardControllerTest extends MyWithRestDoc {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TEST_TOKEN = "Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtZXRhY29kaW5nLWtleSIsImlkIjoxLCJ1c2VybmFtZSI6InNzYXIiLCJleHAiOjQ4NTM0NjE4NTZ9.GJUnp7xc1qwgCffzjdTVeUoayYXdDulBWjCoRxMBJ7a8t4dyTKoAHB3au6_TlZGgigXgSsTzNVIUJy8MnuwCdw";
    @Mock
    private MockHttpSession httpSession;

    @BeforeEach
    public void setUp(){
        httpSession = new MockHttpSession();
        User sessionUser = User.builder().id(1).username("ssar").build();
        httpSession.setAttribute("sessionUser", sessionUser);
    }

    @Test
    public void boards_write_test() throws Exception {
        //given
        BoardRequest.BoardWriteReqDTO requestDTO = new BoardRequest.BoardWriteReqDTO();
        requestDTO.setBoardTitle("테스트1");
        requestDTO.setBoardContent("내용테스트1");
        requestDTO.setBoardCategoryId(4);
        requestDTO.setUserId(1);
        requestDTO.setBoardPics(Arrays.asList("pic1.jpg", "pic2.jpg", "pic3.jpg"));

        ObjectMapper om = new ObjectMapper();
        String requestBody = om.writeValueAsString(requestDTO);
        System.out.println("test1 : " + requestBody);

        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/boards/write")
//                                .header(AUTHORIZATION_HEADER, TEST_TOKEN)
                                .session(httpSession)
                                .content(requestBody)
                                .contentType(MediaType.APPLICATION_JSON)
                );
        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        String responseError = resultActions.andReturn().getResponse().getErrorMessage();
        System.out.println("test2" + responseBody);
        System.out.println("test3" + responseError);
//
//        resultActions
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.response.id").value(17))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.response.boardTitle").value("테스트1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.response.boardContent").value("내용테스트1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.response.boardCategoryId").value(1))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.response.userId").value(3))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.response.username").value("love"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.response.location").value("연산동"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.response.boardPics[0]").value("pic1.jpg"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.response.boardPics[1]").value("pic2.jpg"))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.response.boardPics[2]").value("pic3.jpg"))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.error").isEmpty())
//                .andDo(MockMvcResultHandlers.print())
//                .andDo(document);

    }
}
