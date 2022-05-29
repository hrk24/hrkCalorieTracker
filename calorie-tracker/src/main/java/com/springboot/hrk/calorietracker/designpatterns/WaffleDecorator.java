package com.springboot.hrk.calorietracker.designpatterns;



//Create the decorator class
public class WaffleDecorator implements Waffle{

        public Waffle waffle;

        public WaffleDecorator(Waffle waffle){
            this.waffle = waffle;
        }

        @Override
        public String createWaffle(){
            //ADDING MORE FEATURES as NEEDED
            return waffle.createWaffle();
        }
    }

