package com.clouway;

import com.clouway.Endpointers.EndpointFilter;
import com.clouway.Endpointers.StartsWithKeyword;

public class Main {

    public static void main(String[] args) {

        EndpointFilter filter = new EndpointFilter(new StartsWithKeyword("clo"));

        System.out.println(filter.shouldFilter("https://github.com/clouway/courses/blob/master/docs/java/Testing-with-mocks.md"));


//        SMS msg = new SMS();
//
//        try {
//            System.out.println(msg.send("+555"," esemes"," b"));
//        } catch (InvalidSMSInput invalidSMSInput) {
//            invalidSMSInput.printStackTrace();
//        }

//        Validator validator = null;
//
//        UserRepository repository = new UserRepository(new UserDB(), null);
//
//
//        repository.registerUser(new User("john","17"));
//
//        System.out.println(repository.isAdult("john"));


    }
}
