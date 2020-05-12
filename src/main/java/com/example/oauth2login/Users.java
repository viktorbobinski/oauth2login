package com.example.oauth2login;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue
    Integer id;
    String username;

    public Users(Integer id, String username) {
        this.id = id;
        this.username = username;
    }
}
