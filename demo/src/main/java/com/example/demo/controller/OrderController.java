package com.example.demo.controller;

import com.example.demo.FoodOrderingAppApplication;
import com.example.demo.model.Dish;
import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.service.OrderService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@RestController
public class OrderController {

    private final org.jboss.logging.Logger log = LoggerFactory.logger(FoodOrderingAppApplication.class);

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String getOrder(@ModelAttribute("order")Order order){
        return "order";
    }



    @PostMapping
    public String addOrder(@Valid @ModelAttribute("order")Order order,
                           User user, Dish dish, BindingResult result){
        if(result.hasErrors()) {
            System.out.println("There were errors");
            return "order";
        } else {
            orderService.addOrder(user,dish);
        }

        System.out.println("Order id: " + order.getId());

        return "redirect:order";
    }

    @GetMapping("/order/getAll")
    public Iterable<Order> getAllOrders(){
        log.debugf("getAllOrders", orderService.getAllOrder().toString());

        return orderService.getAllOrder();
    }

    @DeleteMapping("/order/delete/{id}")
    public void deleteOrder(@PathVariable("id")Long id){
        log.debugf("deleteOrder", id);
        orderService.deleteOrderById(id);
    }


}
