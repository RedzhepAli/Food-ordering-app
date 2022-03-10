package com.example.demo.service;

import com.example.demo.model.Dish;
import com.example.demo.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Override
    @Transactional
    public Dish save(Dish dish){
        return dishRepository.save(dish);
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }


}
