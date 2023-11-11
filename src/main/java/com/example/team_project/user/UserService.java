package com.example.team_project.user;

import com.example.team_project._core.erroes.exception.Exception400;
import com.example.team_project._core.erroes.exception.Exception404;
import com.example.team_project._core.utils.JwtTokenUtils;
import com.example.team_project.board.Board;
import com.example.team_project.board.BoardJPARepository;
import com.example.team_project.product.Product;
import com.example.team_project.product.ProductJPARepository;
import com.example.team_project.reply.Reply;
import com.example.team_project.reply.ReplyJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserJPARepository userJPARepository;
    private final EntityManager em;
    private final BoardJPARepository boardJPARepository;
    private final ReplyJPARepository replyJPARepository;
    private final ProductJPARepository productJPARepository;


    // 회원가입
    @Transactional
    public UserResponse.UserJoinRespDTO join(UserRequest.UserJoinReqDTO userJoinReqDTO) {

        User user;
        try {
            user = userJPARepository.save(userJoinReqDTO.toEntity());
        } catch (Exception e) {
            throw new Exception400("존재하는 이메일입니다.");
        }
        return new UserResponse.UserJoinRespDTO(user);
    }

    // 로그인
    public UserResponse.UserLoginRespDTO login(UserRequest.UserLoginReqDTO userLoginReqDTO, HttpSession session) {

        User sessionUser = userJPARepository.findByUsername(userLoginReqDTO.getUsername());

//        User sessionUsers = (User) session.getAttribute("sessionUser");

        System.out.println("jpa에서 받아오는 값"+sessionUser.getUsername());
        if (sessionUser == null) {
            throw new Exception400("유저네임이 없습니다.");
        }

        if (!sessionUser.getPassword().equals(userLoginReqDTO.getPassword())) {
            throw new Exception400("패스워드가 잘못되었습니다.");
        }

        session.setAttribute("sessionUser", sessionUser);
        User session1 = (User) session.getAttribute("sessionUser");

        System.out.println("session: " + session1.getUsername());
//        System.out.println("session: " + session.getAttribute(sessionUser.getUsername()));
//        System.out.println("session: " + session.getAttribute(sessionUser.getPassword()));


        String jwt = JwtTokenUtils.create(sessionUser);

        return new UserResponse.UserLoginRespDTO(jwt, sessionUser);
    }

    // 회원정보수정
    @Transactional
    public UserResponse.UserUpdateRespDTO update(UserRequest.UserUpdateReqDTO userUpdateReqDTO, Integer id) {
        User user = userJPARepository.findById(id).orElseThrow(() -> new Exception404("찾을 수 없습니다.")); // 영속화
        if (user.getId() == null) {
            throw new Exception404("사용자를 찾을 수 없습니다.");
        }

        user.UserUpdate(userUpdateReqDTO.getUserPicUrl(),userUpdateReqDTO.getPassword(),userUpdateReqDTO.getNickname());

        return new UserResponse.UserUpdateRespDTO(user);

    }
    // 나의 당근 - 동네생활 내가 쓴글, 댓글
    public UserResponse.MyWriteRespDTO myBoards(int id) {

        // 글쓴이의 유저아이디가 일치하는 보드들 들고오기
        List<Board> boardWriteList = boardJPARepository.findbyUserId(1);

        // 유저아이디가 일치하는 댓글을 찾기 (보드아이디도 알수있음.)
        List<Reply> replyList = replyJPARepository.findbyUserId(1);
        // 새로운 객체에 List<Board>형태로 담기
        List<Board> replyWriteList = new ArrayList<>();

        for (Reply reply : replyList) {
            Integer boardId = reply.getBoard().getId();
            Board replyboard = boardJPARepository.findById(boardId).orElse(null);
            if (replyboard != null) {
                replyWriteList.add(replyboard);
            }
        }
        return new UserResponse.MyWriteRespDTO(boardWriteList, replyWriteList);
    }

    // 나의 당근 - 판매목록
    public UserResponse.MyProductsListRespDTO saleproducts(Integer id) {

        // 유저아이디가 일치하는 상품들 들고오기
        List<Product> sales = productJPARepository.findByUserId(1);

        List<Product> complements = productJPARepository.findByUserId(1);

        return new UserResponse.MyProductsListRespDTO(sales, complements);
    }

    // 나의 당근 - 구매목록
    public void buyproducts(Integer id) {

    }

    public UserResponse.UserDTO findById(Integer id) {

        User user = userJPARepository.findById(id).orElseThrow(() -> new Exception404("user를 찾을 수 없습니다,"));

        return new UserResponse.UserDTO(user);
    }
}
