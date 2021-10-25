package com.example.codefellowship.repositories;

import com.example.codefellowship.models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
