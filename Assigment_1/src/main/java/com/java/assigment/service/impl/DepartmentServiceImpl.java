package com.java.assigment.service.impl;

import com.java.assigment.dto.DepartmentDTO;
import com.java.assigment.entity.Department;
import com.java.assigment.repository.DepartmentRepository;
import com.java.assigment.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    @Autowired
    ModelMapper mapper;
    @Override
    public List<DepartmentDTO> fillAll() {
        return repository.findAll().stream().map(department -> mapper.map(department, DepartmentDTO.class)).collect(Collectors.toList());
    }
}
