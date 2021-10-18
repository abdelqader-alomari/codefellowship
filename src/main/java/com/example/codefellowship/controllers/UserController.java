package com.example.codefellowship.controllers;

import com.example.codefellowship.models.ApplicationUser;
import com.example.codefellowship.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

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
    public RedirectView signUp(@RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password, @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName, @RequestParam(value = "dateOfBirth") String dateOfBirth,
            @RequestParam(value = "bio") String bio) {
        ApplicationUser newUser = new ApplicationUser(username, encoder.encode(password), firstName, lastName,
                dateOfBirth, bio);
        // newUser.setPosts(PostsRepository.findById(posts).orElseThrow());
        userRepository.save(newUser);
        return new RedirectView("/login");
    }
}
