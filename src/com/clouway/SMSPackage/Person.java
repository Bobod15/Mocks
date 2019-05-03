package com.clouway.SMSPackage;

import com.clouway.Exceptions.InvalidSMSInput;

public class Person implements SMSReceiver {
    private String phoneNumber;

    public Person(String phoneNumber) throws InvalidSMSInput {
        try {
            Integer.parseInt(phoneNumber);
            this.phoneNumber = phoneNumber;
        } catch (NumberFormatException e){
            throw new InvalidSMSInput("Receivers phone number is not a number!");
        }
    }

    @Override
    public void receiveSMS(String title, String message) {

    }
}
