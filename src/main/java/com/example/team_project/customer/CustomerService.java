package com.example.team_project.customer;

import com.example.team_project.reply.ReplyJPARepository;
import com.example.team_project.reply.ReplyResponse;
import lombok.RequiredArgsConstructor;
import com.example.team_project.customer.CustomerResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.example.team_project.user.User;

@Transactional
@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerJPARepository customerJPARepository;

    public List<CustomerResponse.CustomerListRespDTO> findAll() {

        return null;
    }

    public CustomerResponse.CustomerDeleteRespDTO findById() {

        return null;
    }

    // 문의글등록
    public CustomerResponse.CustomerWriteRespDTO save(CustomerRequest.CustomerWriteReqDTO customerWriteReqDTO) {
        Customer responseDTO = customerJPARepository.save(customerWriteReqDTO.toEntity());

        // Customer responseDTO =
        // customerJPARepository.findByCustomerId(customer.getId());
        return new CustomerResponse.CustomerWriteRespDTO(responseDTO);
    }

    // 문의글삭제
    public CustomerResponse.CustomerDeleteRespDTO delete(Integer id) {
        customerJPARepository.deleteById(id);
        return null;
    }

}
