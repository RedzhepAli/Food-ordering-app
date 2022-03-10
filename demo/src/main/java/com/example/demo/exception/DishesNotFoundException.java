package com.example.demo.exception;

public class DishesNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1l;

    public DishesNotFoundException(String dish){
        super("Dishes name not found: " + dish);
    }

}
