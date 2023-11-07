package com.example.team_project.customer;

import com.example.team_project.reply.ReplyJPARepository;
import com.example.team_project.reply.ReplyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerJPARepository customerJPARepository;

    public List<CustomerResponse.CustomerListRespDTO> findAll(){

        return null;
    }

    public CustomerResponse.CustomerDeleteRespDTO findById(){

        return null;
    }

    public CustomerResponse.CustomerWriteRespDTO save(){

        return null;
    }

    public CustomerResponse.CustomerDeleteRespDTO delete(){

        return null;
    }

}
