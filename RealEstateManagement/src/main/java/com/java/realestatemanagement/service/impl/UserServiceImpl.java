package com.java.realestatemanagement.service.impl;

import com.java.realestatemanagement.dto.request.UserCreateRequest;
import com.java.realestatemanagement.entity.UserEntity;
import com.java.realestatemanagement.repository.RoleRepository;
import com.java.realestatemanagement.repository.UserRepository;
import com.java.realestatemanagement.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(UserCreateRequest request) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity user = modelMapper.map(request, UserEntity.class);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        repository.save(user);
    }
}
