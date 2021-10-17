package com.example.codefellowship.repositories;

import com.example.codefellowship.models.ApplicationUser;
import com.example.codefellowship.models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
List <Posts> findAllByUser(ApplicationUser applicationUser);
}
