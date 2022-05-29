package com.springboot.hrk.calorietracker.designpatterns;

public class RedvelvetWaffle extends WaffleDecorator{

    Waffle redvelvetWaffle;

    //create constructor
    public RedvelvetWaffle(Waffle redvelvetWaffle){
        super(redvelvetWaffle);
        this.redvelvetWaffle = redvelvetWaffle;
    }

    //Add Red Velvet flavor to the waffle
    @Override
    public String createWaffle(){
        return	redvelvetWaffle.createWaffle() + addRedVelvet();
    }

    public String addRedVelvet(){
        return "+  RedVelvet Added";
    }
}
