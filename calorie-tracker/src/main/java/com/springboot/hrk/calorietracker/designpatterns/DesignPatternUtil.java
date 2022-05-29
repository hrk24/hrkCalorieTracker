package com.springboot.hrk.calorietracker.designpatterns;


//DECORATOR DESIGN PATTERN
public class DesignPatternUtil {
        public static void main(String[] args){
            Waffle waffle = new RedvelvetWaffle(new ChocolateWaffle(new BasicWaffle()));
            System.out.println(waffle.createWaffle());
        }
    }



