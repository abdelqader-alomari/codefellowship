package com.example.codefellowship.controllers;

import com.example.codefellowship.models.ApplicationUser;
import com.example.codefellowship.models.Posts;
import com.example.codefellowship.repositories.UserRepository;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PostsController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostsRepository postsRepository;

    @PostMapping("/addpost")
    public RedirectView addPost(@AuthenticationPrincipal ApplicationUser user, @RequestParam String body) {
        ApplicationUser currentUser = userRepository.findByUsername(user.getUsername());
        Posts addNewPost = new Posts(body, currentUser);
        postsRepository.save(addNewPost);
        return new RedirectView("/profile");
    }
}
