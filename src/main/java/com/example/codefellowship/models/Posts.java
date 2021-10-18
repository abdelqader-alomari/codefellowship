package com.example.codefellowship.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String body;
    private LocalDateTime createdAt = LocalDateTime.now();
    @ManyToOne
    private ApplicationUser user;

    public void Post() {
    }

    public void Post(String body, ApplicationUser user) {
        this.body = body;
        this.user = user;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getId() {
        return id;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", body='" + body + '\'' + ", created At=" + createdAt + ", user=" + user + '}';
    }
}
