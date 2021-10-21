package com.example.codefellowship.controllers;

import java.security.Principal;
import java.util.List;

import com.example.codefellowship.models.ApplicationUser;
import com.example.codefellowship.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

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

    @GetMapping("/logout")
    public String getLogoutPage() {
        return "index";
    }

    @PostMapping("/signup")
    public RedirectView signUp(String username, String password, String firstName, String lastName, String dateOfBirth,
            String bio) {
        ApplicationUser newUser = new ApplicationUser(username, encoder.encode(password), firstName, lastName,
                dateOfBirth, bio);
        userRepository.save(newUser);
        return new RedirectView("/login");
    }

    @GetMapping("/users/{id}")
    public String profile(@PathVariable long id, Model model, Principal principal) {
        ApplicationUser user = userRepository.findById(id).get();
        model.addAttribute("username", user.getUsername());
        model.addAttribute("userID", user.getId());
        model.addAttribute("user", user);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("dateOfBirth", user.getDataOfBirth());
        model.addAttribute("userBio", user.getBio());
        model.addAttribute("logged", ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return "profile";
    }

    @GetMapping("/profile")
    public String myprofile(Model model, Principal principal) {
        ApplicationUser user = userRepository.findByUsername(principal.getName());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("userID", user.getId());
        model.addAttribute("user", user);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("dateOfBirth", user.getDataOfBirth());
        model.addAttribute("userBio", user.getBio());

        return "profile";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<ApplicationUser> users = userRepository.findAll();
        model.addAttribute("allusers", users);
        return "users";
    }

}
