package com.java.assigment.service;

import com.java.assigment.dto.AccountDTO;
import com.java.assigment.dto.request.AccountCreateRequest;
import com.java.assigment.dto.request.LoginRequest;

public interface AccountService {
    public boolean checkLogin(LoginRequest request);

    public AccountDTO create(AccountCreateRequest request);

}
