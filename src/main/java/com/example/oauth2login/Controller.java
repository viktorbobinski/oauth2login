package com.example.oauth2login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    final UserRepository userRepository;

    @Autowired
    public Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public List<User> helloWorld() {
        return userRepository.findAll();
    }

    @GetMapping("/user")
    public String restricted() {
        return "Hello User!";
    }
}
