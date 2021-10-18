package com.example.codefellowship.repositories;

import com.example.codefellowship.models.ApplicationUser;
import com.example.codefellowship.models.Posts;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PostsRepository extends CrudRepository<Posts, Integer> {
    List<Posts> findAllByUser(ApplicationUser applicationUser);
}
