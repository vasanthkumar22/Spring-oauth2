package com.example.userauth.oauth2.service;

import com.example.userauth.oauth2.model.User;
import com.example.userauth.oauth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }
}
