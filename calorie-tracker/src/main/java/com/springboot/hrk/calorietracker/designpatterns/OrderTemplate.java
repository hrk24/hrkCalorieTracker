package com.springboot.hrk.calorietracker.designpatterns;

abstract class OrderTemplate {
    abstract String selectItem();
    abstract String payItem();

    //Important part is that the template method is final and cannot be over-ridden
    public final String createOrder(){
        selectItem();
        payItem();
        System.out.println("FINAL ORDER CREATED");
        return "FINAL ORDER CREATED";
    }
}
