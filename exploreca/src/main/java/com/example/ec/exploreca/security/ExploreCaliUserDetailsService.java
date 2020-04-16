package com.example.ec.exploreca.security;

import static org.springframework.security.core.userdetails.User.withUsername;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.ec.exploreca.domain.User;
import com.example.ec.exploreca.repo.UserRepository;

/**
 * Service to associate user with password and roles setup in the database.
 *
 * Created by Manpreet
 */
@Component
public class ExploreCaliUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s).orElseThrow(() ->
                new UsernameNotFoundException(String.format("User with name %s does not exist", s)));

        //org.springframework.security.core.userdetails.User.withUsername() builder
        return withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getRoles())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}