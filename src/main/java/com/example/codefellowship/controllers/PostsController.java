package com.example.codefellowship.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

import com.example.codefellowship.models.ApplicationUser;
import com.example.codefellowship.models.Posts;
import com.example.codefellowship.repositories.PostsRepository;
import com.example.codefellowship.repositories.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Controller
public class PostsController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostsRepository postsRepository;

    @PostMapping("/addpost/{id}")
    public RedirectView addPost(@RequestParam String body, @ModelAttribute Posts posts,
            @PathVariable(value = "id") Long id) {

        Posts newPost = new Posts(body, userRepository.findById(id).get());

        postsRepository.save(newPost);

        return new RedirectView("/profile");
    }

    @PostMapping("/addpost")
    public RedirectView addNewPost(@RequestParam String body, Principal principal) {

        ApplicationUser user = (ApplicationUser) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        Posts post = new Posts(body, user);

        postsRepository.save(post);

        return new RedirectView("/profile");
    }
}
