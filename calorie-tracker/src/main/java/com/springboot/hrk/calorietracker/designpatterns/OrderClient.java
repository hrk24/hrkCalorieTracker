package com.springboot.hrk.calorietracker.designpatterns;

import javax.xml.soap.SAAJResult;

public class OrderClient extends OrderTemplate{
    @Override
    public String selectItem(){
        System.out.println("ITEM SELECTED  :: ");
        return "ITEM SELECTED  :: ";
    }
    @Override
    public  String payItem(){
        System.out.println("ITEM PAID :: ");
        return "ITEM PAID :: ";
    }
    public static void main(String[] args){
        OrderClient obj = new OrderClient();
        obj.createOrder();
    }
}
