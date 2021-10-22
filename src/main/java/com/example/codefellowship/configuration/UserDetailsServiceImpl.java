package com.example.codefellowship.configuration;

import com.example.codefellowship.models.ApplicationUser;
import com.example.codefellowship.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = userRepository.findByUsername(username);

        if (user == null) {
            System.out.print("Username not found");
            throw new UsernameNotFoundException((username + " not found"));
        }

        return user;
    }
}
