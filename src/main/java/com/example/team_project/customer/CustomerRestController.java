package com.example.team_project.customer;

import com.example.team_project._core.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CustomerRestController {

    // 문의 전체 조회
    @GetMapping("/customers")
    public ResponseEntity<?> CustomerList(){

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    // 문의 상세 조회
    @GetMapping("/customers/{id}")
    public ResponseEntity<?> customerDetail(@PathVariable Integer id){

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    // 문의 등록
    @PostMapping("/customers/write")
    public ResponseEntity<?> customerWrite(){

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    // 문의 삭제
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> customerDelete(@PathVariable Integer id){

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

}
