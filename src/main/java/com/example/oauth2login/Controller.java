package com.example.oauth2login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//test for
@RestController
public class Controller {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/user")
    public String restricted() {
        return "Hello User!";
    }
}
