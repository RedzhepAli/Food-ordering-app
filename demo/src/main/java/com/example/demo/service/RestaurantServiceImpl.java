package com.example.demo.service;

import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.model.Dish;
import com.example.demo.model.Restaurant;
import com.example.demo.model.RestaurantReport;
import com.example.demo.repository.DishRepository;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DishRepository dishRepository;

    @Override
    @Transactional
    public Restaurant addRestaurant(Restaurant restaurant){

        restaurant = restaurantRepository.save(restaurant);

        if (restaurant.getId() == null) {
            Dish dish = new Dish();
            dish.setName("Dishes name");
            dish.setDescription("Dishes description");
            dish.setUrl("url");
            dish.setRestaurant(restaurant);

            dishRepository.save(dish);
        }

        return restaurant;
    }

    @Override
    public List<Restaurant> findAll(){ return restaurantRepository.findAll();}

    @Override
    public List<RestaurantReport> findAllReports(){
        return restaurantRepository.restaurantReport();
    }

    @Override
    public Restaurant findById(Long id){
        return restaurantRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

}
