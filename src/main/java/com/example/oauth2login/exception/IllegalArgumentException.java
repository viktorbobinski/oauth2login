package com.example.oauth2login.exception;

public class IllegalArgumentException extends RuntimeException {

    public IllegalArgumentException(int id) {
        super("Could not find User with {id= " + id + "}");
    }
}
