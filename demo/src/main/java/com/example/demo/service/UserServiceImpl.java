package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User save(User user){

        return userRepository.save(user);
    }


    @Override
    @Transactional
    public void addUser(String firstName, String lastName, String email, String password, String address, String telephone){

        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setAddress(address);
        user.setTelephone(telephone);

        save(user);
    }


    @Override
    public List<User> findAll(){ return userRepository.findAll();}

    @Override
    public void deleteUser(String name){
        userRepository.deleteById(name);
    }

    @Override
    public User findUserById(String user){
        return userRepository.findById(user).orElseThrow(() -> new UserNotFoundException(user));
    }
}
