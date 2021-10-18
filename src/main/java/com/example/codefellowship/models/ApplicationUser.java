package com.example.codefellowship.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class ApplicationUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String dataOfBirth;
    private String bio;

    @OneToMany(mappedBy = "user")
    private List<Posts> posts;

    public ApplicationUser(String username, String password, String firstName, String lastName, String dataOfBirth,
            String bio) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dataOfBirth = dataOfBirth;
        this.bio = bio;
    }

    public ApplicationUser() {

    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDataOfBirth() {
        return dataOfBirth;
    }

    public String getBio() {
        return bio;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPostList(List<Posts> postList) {
        this.posts = postList;
    }

}
