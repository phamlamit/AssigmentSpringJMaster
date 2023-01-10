package com.java.assigment.controller;

import com.java.assigment.dto.TicketDTO;
import com.java.assigment.dto.request.TicketCreateRequest;
import com.java.assigment.dto.request.TicketSearchRequest;
import com.java.assigment.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TicketController {

    @Autowired
    private TicketService service;

    @GetMapping("/tickets")
    public String getTickets(Model model) {
        model.addAttribute("tickets", service.fillAll());
        return "/tickets";
    }

    @PostMapping("/create")
    public String create(Model model, @Validated TicketCreateRequest request) {
        if (service.create(request) != null) {
            model.addAttribute("message", "Ticket has been create successfully");
        }
        return "/tickets";
    }

    @GetMapping("/search")
    public List<TicketDTO> search(TicketSearchRequest request) {
        return service.search(request);
    }
}
