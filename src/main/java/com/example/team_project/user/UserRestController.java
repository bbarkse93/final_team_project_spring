package com.example.team_project.user;

import com.example.team_project._core.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserRestController {


    private final UserService userService;
    private final HttpSession session;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody @Valid UserRequest.UserJoinReqDTO userJoinReqDTO, Errors errors) {
        UserResponse.UserJoinRespDTO responseDTO = userService.join(userJoinReqDTO);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserRequest.UserLoginReqDTO userLoginReqDTO, Errors errors) {

        UserResponse.UserLoginRespDTO responseDTO = userService.login(userLoginReqDTO, session);
//        System.out.println("로그인 : " + sessionUser.getId());
        return ResponseEntity.ok().header("Authorization", responseDTO.getJwt())
                .body(ApiUtils.success(responseDTO.getUser()));

    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout() {
        session.invalidate();
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> findUser(@PathVariable Integer id) {

        UserResponse.UserDTO ResponseDTO = userService.findById(id);
        return ResponseEntity.ok().body(ApiUtils.success(ResponseDTO));
    }

    // 회원정보 수정
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserRequest.UserUpdateReqDTO userUpdateReqDTO,
                                        @PathVariable Integer id, Error error) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        System.out.println("세션 테스트세트스테스트1243 : " + sessionUser.getId());
        UserResponse.UserUpdateRespDTO responseDTO = userService.update(userUpdateReqDTO, sessionUser);
        session.setAttribute("sessionUser", sessionUser);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 나의 당근 - 동네생활 내가 쓴글, 댓글
    @GetMapping("users/myboards")
    public ResponseEntity<?> myBoards(Integer id) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        System.out.println("세션 테스트세트스테스트 : " + sessionUser.getId());
        UserResponse.MyWriteRespDTO responseDTO = userService.myBoards(sessionUser.getId());

        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 나의 당근 - 판매목록
    @GetMapping("users/saleproducts")
    public ResponseEntity<?> saleproducts(Integer id) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        UserResponse.MyProductsListRespDTO responseDTO = userService.saleproducts(sessionUser.getId());
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 나의 당근 - 구매목록
    @GetMapping("users/buyproducts")
    public ResponseEntity<?> buyproducts(Integer id) {

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }
}
