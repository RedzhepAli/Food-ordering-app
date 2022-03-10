package com.example.demo.service;

import com.example.demo.model.Dish;
import com.example.demo.model.Order;
import com.example.demo.model.User;



public interface OrderService {

    Order addOrder(User user, Dish dish);

    Order findById(Long id);

    void deleteOrderById(Long id);

    Iterable<Order> getAllOrder();


}
