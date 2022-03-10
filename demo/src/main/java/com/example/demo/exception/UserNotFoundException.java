package com.example.demo.exception;

public class UserNotFoundException extends  RuntimeException{
    private static final long serialVersionUID = 1l;

    public UserNotFoundException(String user){
        super("User id not found: " + user);
    }
}
