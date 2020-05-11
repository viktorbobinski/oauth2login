package com.example.oauth2login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/user")
    public String restricted() {
        return "Hello Usersss!";
    }

    @GetMapping("/data")
    public String data() {
        return "Hi";
    }
}
