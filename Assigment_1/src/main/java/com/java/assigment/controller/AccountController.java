package com.java.assigment.controller;

import com.java.assigment.dto.request.AccountCreateRequest;
import com.java.assigment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService service;

    @GetMapping("/create")
    public String create(Model model) {
        return "signup";
    }

    @PostMapping("/create")
    public String create(Model model, @Validated AccountCreateRequest request) {
        if (service.create(request) != null) {
            model.addAttribute("message", "Account have been created successfully");
        }
        return "signup";
    }
}
