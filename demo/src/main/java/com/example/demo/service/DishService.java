package com.example.demo.service;

import com.example.demo.model.Dish;

import javax.transaction.Transactional;
import java.util.List;

public interface DishService {
    @Transactional
    Dish save(Dish dish);

    List<Dish> findAll();
}
