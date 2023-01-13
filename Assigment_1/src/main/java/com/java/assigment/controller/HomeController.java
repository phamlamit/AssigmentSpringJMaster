package com.java.assigment.controller;

import com.java.assigment.dto.request.LoginRequest;
import com.java.assigment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private AccountService service;

    @Autowired
    MessageSource messageSource;

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("request", new LoginRequest());
        return "login";
    }

    @PostMapping(value = "/check-login")
    public String login(Model model, @Validated @ModelAttribute("request") LoginRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        if (service.checkLogin(request)) {
            return "redirect:/ticket";
        }
        model.addAttribute("msg", "Password or Username is wrong. Please check again");
        model.addAttribute("request", new LoginRequest());
        return "/login";
    }
}
