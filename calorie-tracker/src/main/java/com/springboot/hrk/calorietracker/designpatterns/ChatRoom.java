package com.springboot.hrk.calorietracker.designpatterns;

import java.util.HashMap;
import java.util.Map;

//This is the concrete Mediator Class
public class ChatRoom implements IChatRoom{
    private Map<String, User> usersMap = new HashMap<>();

    @Override
    public void sendMessage(String msg, String userId) {
        User u = usersMap.get(userId);
        u.receive(msg);
    }

    @Override
    public void addUser(User u) {
        usersMap.put(u.getId(),u);
    }
}
