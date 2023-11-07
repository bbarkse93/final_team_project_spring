package com.example.team_project.customer;

import com.example.team_project._core.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> CustomerDetail(){

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    // 문의 등록
    @PostMapping("/customers/write")
    public ResponseEntity<?> CustomerWrite(){

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    // 문의 삭제
    @GetMapping("/customers/delete")
    public ResponseEntity<?> CustomerDelete(){

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

}