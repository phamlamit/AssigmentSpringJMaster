package com.java.assigment.service;

import com.java.assigment.dto.TicketDTO;
import com.java.assigment.dto.request.TicketCreateRequest;
import com.java.assigment.dto.request.TicketSearchRequest;

import java.util.List;

public interface TicketService {

    public List<TicketDTO> fillAll();

    public TicketDTO create(TicketCreateRequest request);

    public List<TicketDTO> search(TicketSearchRequest request);
}
