package com.springboot.hrk.calorietracker.designpatterns;

public interface IChatRoom {
    public void sendMessage(String msg, String userId);
    public void addUser(User user);
}
