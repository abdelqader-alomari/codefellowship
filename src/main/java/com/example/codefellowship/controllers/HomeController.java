package com.example.codefellowship.controllers;

import java.security.Principal;

import com.example.codefellowship.models.ApplicationUser;
import com.example.codefellowship.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String homePage(Model model, Principal principal) {
        ApplicationUser user = userRepository.findByUsername(principal.getName());
        model.addAttribute("username", user.getUsername());
        return "index";
    }
}