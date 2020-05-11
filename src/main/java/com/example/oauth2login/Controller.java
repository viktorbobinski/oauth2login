package com.example.oauth2login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

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
        return "Hello User!";
    }

    @GetMapping("/data")
    public List<User> data() {
        return Arrays.asList(null)/*userRepository.findAll()*/;
    }
}
