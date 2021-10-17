package com.example.codefellowship.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String courses;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    public Date createdAt;

    @ManyToOne
    private ApplicationUser applicationUser;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser user;

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }

    public Posts(String name, String courses) {
        this.name = name;
        this.courses = courses;
    }

    public Posts() {

    }

    public String getName() {
        return name;
    }

    public String getCourses() {
        return courses;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }
}
