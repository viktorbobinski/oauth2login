package com.example.oauth2login;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
