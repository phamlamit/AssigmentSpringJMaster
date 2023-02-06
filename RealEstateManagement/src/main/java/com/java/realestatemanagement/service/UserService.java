package com.java.realestatemanagement.service;

import com.java.realestatemanagement.dto.request.UserCreateRequest;

public interface UserService {
    void save(UserCreateRequest request);
}
