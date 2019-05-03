package com.clouway.DBRepo;

import javax.xml.validation.Validator;

public class UserRepository {
    private UserDB userDB;
    private Validator validator;

    public UserRepository(UserDB userDB, Validator validator) {
        this.userDB = userDB;
        this.validator = validator;
    }

    public void registerUser(User user) {
        userDB.add(user);
    }

    public boolean isAdult(String name) {
        String age = userDB.getByName(name).getAge();
        Integer intAge = Integer.parseInt(age);
        return intAge >= 18;
    }
}
