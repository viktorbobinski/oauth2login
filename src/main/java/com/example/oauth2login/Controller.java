package com.example.oauth2login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("/user")
    public ResponseEntity<String> restricted() {
        return ResponseEntity.ok("Hello User!");
    }

    @GetMapping("/data")
    public ResponseEntity<List<User>> data() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
