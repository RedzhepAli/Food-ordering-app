package com.example.demo.model;

public class RestaurantReport {

    private String name;
    private String dishName;
    private String dishDescription;
    private String dishURL;

    public RestaurantReport(String name, String dishName, String dishDescription, String dishURL) {
        this.name = name;
        this.dishName = dishName;
        this.dishDescription = dishDescription;
        this.dishURL = dishURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public String getDishURL() {
        return dishURL;
    }

    public void setDishURL(String dishURL) {
        this.dishURL = dishURL;
    }
}
