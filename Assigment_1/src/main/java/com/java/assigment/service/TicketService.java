package com.java.assigment.service;

import com.java.assigment.dto.TicketDTO;
import com.java.assigment.dto.request.TicketCreateRequest;

import java.util.List;

public interface TicketService {
    public TicketDTO create(TicketCreateRequest request);

    public List<TicketDTO> search(TicketCreateRequest request);
}
