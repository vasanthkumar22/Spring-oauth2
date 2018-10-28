package com.example.userauth.oauth2.service;

import com.example.userauth.oauth2.model.Role;
import com.example.userauth.oauth2.model.User;
import com.example.userauth.oauth2.repository.RoleRepository;
import com.example.userauth.oauth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public User findUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // fix to add multiple role records to the role table
        Role userRole = roleRepository.findByName("ROLE_USER");

        user.setRoles(Collections.singleton(userRole));
        return userRepository.save(user);
    }
}
