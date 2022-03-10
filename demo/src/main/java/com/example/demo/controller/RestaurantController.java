package com.example.demo.controller;

import com.example.demo.model.Restaurant;
import com.example.demo.model.RestaurantReport;
import com.example.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("restaurant")
    public String getRestaurant(@ModelAttribute("restaurant") Restaurant restaurant) {
        return "restaurant";
    }

    @GetMapping("restaurants")
    public @ResponseBody
    List<Restaurant>
    getRestaurants() {
       List<Restaurant> restaurants = restaurantService.findAll();

       return restaurants;
    }

    @GetMapping("restaurant-reports")
    public @ResponseBody
    List<RestaurantReport>
    getRestaurantReports() {
        List<RestaurantReport> restaurantsReports= restaurantService.findAllReports();

        return restaurantsReports;
    }



    @PostMapping("restaurant")
    public String addRestaurant(@Valid @ModelAttribute ("restaurant")
                                            Restaurant restaurant,
                                  BindingResult result) {

        if(result.hasErrors()) {
            System.out.println("There were errors");
            return "restaurant";
        } else {
            restaurantService.addRestaurant(restaurant);
        }

        System.out.println("Restaurant: " + restaurant.getName());

        return "redirect:restaurant";
    }

    @PostMapping("restaurant/update")
    public @ResponseBody Restaurant updateRestaurant (@Valid @ModelAttribute("restaurant")
                                                                      Restaurant restaurant,
                                                                      BindingResult result) {

        return restaurantService.addRestaurant(restaurant);
    }
}
