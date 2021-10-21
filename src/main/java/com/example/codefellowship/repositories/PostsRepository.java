package com.example.codefellowship.repositories;

import com.example.codefellowship.models.Posts;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository<Posts, Long> {
}
