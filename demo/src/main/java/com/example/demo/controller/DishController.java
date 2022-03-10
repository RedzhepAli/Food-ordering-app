package com.example.demo.controller;

import com.example.demo.model.Dish;
import com.example.demo.model.Restaurant;
import com.example.demo.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("dish")
    public String getDish(@ModelAttribute("dish") Dish Dish) {
        return "dish";
    }



    @GetMapping("dishes")
    public @ResponseBody
    List<Dish>
    getDishes() {
        List<Dish> dishes = dishService.findAll();
        return dishes;
    }
}
