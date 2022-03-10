package com.example.demo.controller;

import com.example.demo.FoodOrderingAppApplication;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    private final org.jboss.logging.Logger log1 = LoggerFactory.logger(FoodOrderingAppApplication.class);

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getUser(@RequestParam(value = "firstname") String firstname,
                        @RequestParam(value = "lastname") String lastname,
                        @RequestParam(value = "email") String email,
                        @RequestParam(value = "password") String password,
                        @RequestParam(value = "address") String address,
                        @RequestParam(value = "telephone") String telephone) {

        User user = new User();


        user.setFirstName(firstname);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPassword(password);
        user.setAddress(address);
        user.setTelephone(telephone);

        return user;
    }

    @PostMapping("/user")
    public User postUser(User user){
        System.out.println("User firstname: " + user.getFirstName());

        userService.save(user);

        return user;
    }

    @GetMapping("/user/find{user}")
    public User findUserById(@PathVariable("user")String user){
        log1.debugf("user id:", user);

        return userService.findUserById(user);
    }


    @DeleteMapping("/delete/{name}")
    public void deleteUser(@PathVariable("name")String name){
        log1.debugf("deleteUser", name);

        userService.deleteUser(name);
    }

    @GetMapping("users")
    public @ResponseBody
    List<User>
    getDishes() {
        List<User> users = userService.findAll();
        return users;
    }


}
