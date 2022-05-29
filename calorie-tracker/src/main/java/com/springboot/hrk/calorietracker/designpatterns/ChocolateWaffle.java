package com.springboot.hrk.calorietracker.designpatterns;

//Create some concrete classes - different types of waffles
public class ChocolateWaffle extends WaffleDecorator{

    Waffle chocolateWaffle;

    //create constructor
    public ChocolateWaffle(Waffle chocolateWaffle){
        super(chocolateWaffle);
        this.chocolateWaffle=chocolateWaffle;
    }

    //Add Chocolate flavor to the waffle
    @Override
    public String createWaffle(){
        return	chocolateWaffle.createWaffle() + addChocolate();
    }

    public String addChocolate(){
        return "+  Chocolate Added";
    }
}
