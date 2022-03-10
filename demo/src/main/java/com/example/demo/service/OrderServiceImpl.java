package com.example.demo.service;

import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.model.Dish;
import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.repository.DishRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DishRepository dishRepository;

    @Override
    @Transactional
    public Order addOrder(User user, Dish dish){

        Order order = new Order();

        userRepository.save(user);
        dishRepository.save(dish);

        order.setUser(user);
        order.setDish(dish);

        orderRepository.save(order);

        return order;
    }

    @Override
    public Iterable<Order> getAllOrder(){
        List<Order> orderList = orderRepository.findAll();

        if (orderList.size() > 0){
            return orderList;
        } else {
            return new ArrayList<Order>();
        }
    }

    @Override
    public Order findById(Long id){
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public void deleteOrderById(Long id){
        orderRepository.deleteById(id);

    }


}
