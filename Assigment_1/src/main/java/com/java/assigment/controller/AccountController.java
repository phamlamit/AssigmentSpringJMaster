package com.java.assigment.controller;

import com.java.assigment.dto.request.AccountCreateRequest;
import com.java.assigment.dto.request.LoginRequest;
import com.java.assigment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService service;

    @GetMapping("/signup")
    public String create(Model model) {
        model.addAttribute("request", new AccountCreateRequest());
        return "signup";
    }

    @PostMapping("/signup")
    public String create(Model model, @Validated @ModelAttribute("request") AccountCreateRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/signup";
        }
        if (service.create(request) != null) {
            model.addAttribute("msg", "Account have been created successfully");
            model.addAttribute("request", new LoginRequest());
        }
        return "login";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(Model model) {
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(Model model, @RequestParam("email") String email) {
        if (service.forgotPassword(email) == null) {
            model.addAttribute("msg", "Can't find account have " + email);
            return "forgot-password";
        }
        model.addAttribute("msg", "Reset password completely");
        model.addAttribute("request", new LoginRequest());
        return "login";
    }
}
