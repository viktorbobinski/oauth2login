package com.example.oauth2login.controller;

import com.example.oauth2login.model.User;
import com.example.oauth2login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("/user")
    public ResponseEntity<User> data(@RequestParam(value = "id", defaultValue = "1") int id) {
        return ResponseEntity.ok(userService.getById(id));
    }
}
