package com.example.oauth2login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/")
    public List<Users> helloWorld() {
        return usersRepository.findAll();
    }

    @GetMapping("/user")
    public String restricted() {
        return "Hello Usersss!";
    }
}
