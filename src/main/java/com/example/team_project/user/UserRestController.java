package com.example.team_project.user;

import com.example.team_project._core.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @PutMapping("/users/update")
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserRequest.UserUpdateReqDTO userUpdateReqDTO,
            HttpServletRequest request, Error error) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        System.out.println("session : " + sessionUser.getId());
        UserResponse.UserUpdateRespDTO responseDTO = userService.update(userUpdateReqDTO, sessionUser.getId());
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 나의 당근 - 동네생활 내가 쓴글, 댓글
    @GetMapping("users/myboards")
    public ResponseEntity<?> myBoards(Integer id) {
        // 이따 유저정보 가져오는걸로 바꿔야함!
        UserResponse.MyWriteRespDTO responseDTO = userService.myBoards(1);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 나의 당근 - 판매목록
    @GetMapping("users/saleproducts")
    public ResponseEntity<?> saleproducts(Integer id) {
        UserResponse.MyProductsListRespDTO responseDTO = userService.saleproducts(1);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 나의 당근 - 구매목록
    @GetMapping("users/buyproducts")
    public ResponseEntity<?> buyproducts(Integer id) {

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }
}
