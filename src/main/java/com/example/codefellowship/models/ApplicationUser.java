package com.example.codefellowship.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class ApplicationUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true)
    private String username;
    private String password;

    public String firstName;
    public String lastName;
    public String dateOfBirth;
    public String bio;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "users")
    List<Posts> posts;

    public List<Posts> getPosts() {
        return this.posts;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "follower_follower", joinColumns = @JoinColumn(name = "from_id"), inverseJoinColumns = @JoinColumn(name = "to_id"))
    List<ApplicationUser> followers = new ArrayList<>();
    @ManyToMany(mappedBy = "followers")
    List<ApplicationUser> following = new ArrayList<>();

    public void setPost(List<Posts> posts) {
        this.posts = posts;
    }

    public ApplicationUser() {

    }

    public ApplicationUser(String username, String password, String firstName, String lastName, String dateOfBirth,
            String bio) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
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

    public String getDateOfBirth() {
        return dateOfBirth;
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
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public List<ApplicationUser> getFollowers() {
        return this.followers;
    }

    public void setFollowers(List<ApplicationUser> followers) {
        this.followers = followers;
    }

    public List<ApplicationUser> getFollowing() {
        return this.following;
    }

    public void setFollowing(List<ApplicationUser> following) {
        this.following = following;
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
}
