package com.example.codefellowship.controllers;

import com.example.codefellowship.models.ApplicationUser;
import com.example.codefellowship.repositories.PostsRepository;
import com.example.codefellowship.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    PostsRepository postsRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder encoder;

    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }


    @PostMapping("/signup")
    public RedirectView signUp(@RequestParam String username, @RequestParam String password, @RequestParam Long posts) {
        ApplicationUser newUser = new ApplicationUser(username, encoder.encode(password));
//        newUser.setPosts(PostsRepository.findById(posts).orElseThrow());
        userRepository.save(newUser);
        return new RedirectView("/login");
    }
}


