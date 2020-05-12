package com.example.oauth2login.service;

import com.example.oauth2login.exception.IllegalArgumentException;
import com.example.oauth2login.model.User;
import com.example.oauth2login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(int id) {
        return userRepository.findById(id).orElseThrow(() ->  new IllegalArgumentException(id));
    }
}
