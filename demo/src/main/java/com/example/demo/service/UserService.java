package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    void addUser(String firstName, String lastName, String email, String password, String address, String telephone);

    List<User> findAll();

    void deleteUser(String name);

    User findUserById(String user);
}
