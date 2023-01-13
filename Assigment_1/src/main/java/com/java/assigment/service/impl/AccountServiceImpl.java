package com.java.assigment.service.impl;

import com.java.assigment.dto.AccountDTO;
import com.java.assigment.dto.request.AccountCreateRequest;
import com.java.assigment.dto.request.LoginRequest;
import com.java.assigment.entity.Account;
import com.java.assigment.repository.AccountRepository;
import com.java.assigment.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean checkLogin(LoginRequest request) {
        return repository.findByEmailAndPassword(request.getEmail(), request.getPassword()).isPresent();
    }

    @Override
    public AccountDTO create(AccountCreateRequest request) {
        if (request.getPassword().equals(request.getRePassword())) {
            if (!repository.findByEmail(request.getEmail()).isPresent()) {
                Account account = mapper.map(request, Account.class);
                return mapper.map(repository.save(account), AccountDTO.class);
            }
            return null;
        }
        return null;
    }

    @Override
    public AccountDTO forgotPassword(String email) {
        if (repository.findByEmail(email).isPresent()) {
            Account account = repository.findByEmail(email).get();
            account.setPassword("123");
            return mapper.map(repository.save(account), AccountDTO.class);
        }
        return null;
    }
}
