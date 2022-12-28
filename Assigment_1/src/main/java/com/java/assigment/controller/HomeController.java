package com.java.assigment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/")
    public String login(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
        return "login";
    }
}
