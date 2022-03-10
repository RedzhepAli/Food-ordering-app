package com.example.demo.exception;

public class OrderNotFoundException extends RuntimeException{
    private static final long svUID = 1l;

    public OrderNotFoundException(Long order){
        super("Order id not found: " + order);
    }
}
