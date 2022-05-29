package com.springboot.hrk.calorietracker.designpatterns;

//Create a Basic Waffle -- Super waffle class that will serve as a base class
public class BasicWaffle implements Waffle {

    @Override
    public String createWaffle() {
        //CREATE A BASE WAFFLE
        return "Created BASE WAFFLE";
    }
}
