package com.example.team_project.customer;

import com.example.team_project._core.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CustomerRestController {
    private final CustomerService customerService;

    // 문의 전체 조회
    @GetMapping("/customers")
    public ResponseEntity<?> CustomerList() {

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    // 문의 상세 조회
    @GetMapping("/customers/{id}")
    public ResponseEntity<?> CustomerDetail() {

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    // 문의 등록
    @PostMapping("/customers/write")
    public ResponseEntity<?> CustomerWrite(@RequestBody CustomerRequest.CustomerWriteReqDTO customerWriteReqDTO) {
        CustomerResponse.CustomerWriteRespDTO responseDTO = customerService.save(customerWriteReqDTO);

        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // 문의 삭제
    @DeleteMapping("/customers/delete/{id}")
    public ResponseEntity<?> CustomerDelete(@PathVariable Integer id) {
        customerService.delete(id);
        return ResponseEntity.ok().body(ApiUtils.success("문의 삭제 완료"));
    }
}
