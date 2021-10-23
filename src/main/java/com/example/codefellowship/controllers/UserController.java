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
import org.springframework.security.core.annotation.AuthenticationPrincipal;

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
        return "login";
    }

    @PostMapping("/signup")
    public RedirectView signUp(String username, String password, String firstName, String lastName, String dateOfBirth,
            String bio) {
        ApplicationUser newUser = new ApplicationUser(username, encoder.encode(password), firstName, lastName,
                dateOfBirth, bio);
        userRepository.save(newUser);
        return new RedirectView("/login");
    }

    @GetMapping("/user")
    public String profile(@RequestParam long id, Model model, Principal principal) {
        ApplicationUser user = userRepository.findById(id).get();
        model.addAttribute("username", user.getUsername());
        model.addAttribute("userID", user.getId());
        model.addAttribute("user", user);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("dateOfBirth", user.getDateOfBirth());
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
        model.addAttribute("dateOfBirth", user.getDateOfBirth());
        model.addAttribute("userBio", user.getBio());

        return "myprofile";
    }

    @GetMapping("/users")
    public String getUsers(Model model, Principal principal) {
        List<ApplicationUser> users = userRepository.findAll();
        model.addAttribute("allusers", users);
        ApplicationUser user = userRepository.findByUsername(principal.getName());
        model.addAttribute("username", user.getUsername());
        return "users";
    }

    @PostMapping("/follow")
    public RedirectView followUser(@AuthenticationPrincipal ApplicationUser user, @RequestParam Long id) {
        ApplicationUser feed = userRepository.findByUsername(user.getUsername());
        ApplicationUser follow = userRepository.findById(id).get();
        feed.getFollowers().add(follow);
        userRepository.save(feed);
        return new RedirectView("/feed");
    }

    @GetMapping("/feed")
    public String getUsersInfo(@AuthenticationPrincipal ApplicationUser user, Model model) {
        model.addAttribute("username", user.getUsername());
        ApplicationUser feed = userRepository.findByUsername(user.getUsername());
        List<ApplicationUser> myfollowers = feed.getFollowers();
        model.addAttribute("allfollowers", myfollowers);
        return "feed";
    }
}
