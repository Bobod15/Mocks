package com.clouway.DBRepo;

import java.util.LinkedList;
import java.util.List;

public class UserDB {
    private List<User> users = new LinkedList<>();

    public User add(User user){
        users.add(user);
        return user;
    }

    public User getByName(String name){
        for (User person:users) {
            if(person.getName().equals(name))
                return person;
        }
        return null;
    }
}
