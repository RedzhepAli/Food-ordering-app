package com.example.demo.service;

import com.example.demo.model.Restaurant;
import com.example.demo.model.RestaurantReport;

import javax.transaction.Transactional;
import java.util.List;

public interface RestaurantService {
    @Transactional
    Restaurant addRestaurant(Restaurant restaurant);

    @Transactional
    List<Restaurant> findAll();

    List<RestaurantReport> findAllReports();

    Restaurant findById(Long id);
}
