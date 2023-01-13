package com.java.assigment.controller;

import com.java.assigment.dto.request.TicketCreateRequest;
import com.java.assigment.dto.request.TicketSearchRequest;
import com.java.assigment.service.DepartmentService;
import com.java.assigment.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService service;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    public String getTickets(Model model) {
        model.addAttribute("departments", departmentService.fillAll());
        model.addAttribute("tickets", service.fillAll());
        model.addAttribute("searchRequest", new TicketSearchRequest());
        model.addAttribute("ticketCreateRequest", new TicketCreateRequest());
        return "ticket";
    }

    @PostMapping("/create")
    public String create(Model model, @Validated @ModelAttribute("ticketCreateRequest") TicketCreateRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/ticket";
        }
        if (service.create(request) != null) {
            model.addAttribute("message", "Ticket has been create successfully");
        }
        return "redirect:/ticket";
    }

    @GetMapping("/search")
    public String search(Model model, TicketSearchRequest searchRequest) {
        model.addAttribute("tickets", service.search(searchRequest));
        model.addAttribute("departments", departmentService.fillAll());
        model.addAttribute("searchRequest", new TicketSearchRequest());
        model.addAttribute("ticketCreateRequest", new TicketCreateRequest());
        return "ticket";
    }
}
