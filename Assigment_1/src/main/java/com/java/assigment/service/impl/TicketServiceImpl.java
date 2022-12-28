package com.java.assigment.service.impl;

import com.java.assigment.dto.TicketDTO;
import com.java.assigment.dto.request.TicketCreateRequest;
import com.java.assigment.entity.Department;
import com.java.assigment.entity.Ticket;
import com.java.assigment.repository.CustomRepository;
import com.java.assigment.repository.DepartmentRepository;
import com.java.assigment.repository.TicketRepository;
import com.java.assigment.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository repository;

    @Autowired
    private CustomRepository customRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TicketDTO create(TicketCreateRequest request) {
        Ticket ticket = modelMapper.map(request, Ticket.class);
        Department department = departmentRepository.findById(request.departmentId).orElse(null);
        if (department != null) {
            ticket.setDepartmentId(department);
            ticket.setCreatedDate(Date.from(Instant.now()));
        }
        return modelMapper.map(repository.save(ticket), TicketDTO.class);
    }

    @Override
    public List<TicketDTO> search(TicketCreateRequest request) {
        return customRepository.searchTicket(request).stream().map(ticket -> {
            return modelMapper.map(ticket, TicketDTO.class);
        }).collect(Collectors.toList());
    }
}
