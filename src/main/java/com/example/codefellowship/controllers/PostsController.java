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

import com.example.codefellowship.models.ApplicationUser;
import com.example.codefellowship.models.Posts;
import com.example.codefellowship.repositories.PostsRepository;
import com.example.codefellowship.repositories.UserRepository;

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

    @GetMapping("/addpost/{id}")
    public String profile(@PathVariable long id, Model model) {
        Posts user = postsRepository.findById(id).get();
        model.addAttribute("body", user.getBody());
        model.addAttribute("created_at", user.getCreatedAt());
        model.addAttribute("posts", user);
        return "profile";
    }

}
