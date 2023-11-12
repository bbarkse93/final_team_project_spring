package com.example.team_project.customer;

import com.example.team_project.reply.ReplyJPARepository;
import com.example.team_project.reply.ReplyResponse;
import lombok.RequiredArgsConstructor;

import com.example.team_project.board.BoardResponse.BoardDetailRespDTO.ReplyDTO.UserDTO;
import com.example.team_project.customer.CustomerResponse;
import com.example.team_project.customer.CustomerResponse.CustomerWriteRespDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.example.team_project.user.User;
import com.example.team_project.user.UserJPARepository;
import com.example.team_project.user.UserResponse;
import com.example.team_project.user.UserService;

@Transactional
@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerJPARepository customerJPARepository;
    // private final UserJPARepository userJPARepository; 

    public List<CustomerResponse.CustomerListRespDTO> findAll() {

        return null;
    }

    public CustomerResponse.CustomerDeleteRespDTO findById() {

        return null;
    }

    // 문의글등록
    public CustomerResponse.CustomerWriteRespDTO save(CustomerRequest.CustomerWriteReqDTO customerWriteReqDTO) {
        Customer responseDTO = customerJPARepository.save(customerWriteReqDTO.toEntity());
        //User responseUserDTO = customerJPARepository.findByUserId(customerWriteReqDTO.getId());
        // Customer responseDTO =
        System.out.println(customerWriteReqDTO.getId());
        String username = customerJPARepository.findByUserId(responseDTO.getUser().getId());
        System.out.println(username);

        
        User user = new User(responseDTO.getUser().getId(), username);
        Customer customer = new Customer(responseDTO.getId(), responseDTO.getTitle(), responseDTO.getContent(), responseDTO.getCreatedAt(), user);

        System.out.println(user.getUsername());
        CustomerResponse.CustomerWriteRespDTO dto = new CustomerResponse.CustomerWriteRespDTO(customer);
        
        return dto;
    }

    // 문의글삭제
    public CustomerResponse.CustomerDeleteRespDTO delete(Integer id) {
        customerJPARepository.deleteById(id);
        return null;
    }

}
