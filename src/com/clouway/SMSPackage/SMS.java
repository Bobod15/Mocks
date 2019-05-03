package com.clouway.SMSPackage;

import com.clouway.Exceptions.InvalidSMSInput;

import java.util.LinkedList;
import java.util.List;

public class SMS {
    private String receiversPhoneNumber;
    private String title;
    private String message;

    public SMS() {
    }

//    public List<String> send(String receiver, String title, String message) throws InvalidSMSInput {
//        message = message.trim();
//
//        if(isNullOrEmpty(receiver) || isNullOrEmpty(title) || isNullOrEmpty(message)){
//            throw new InvalidSMSInput("Receiver, title and message cant be empty!");
//        }
//        if (message.length()>120){
//            throw new InvalidSMSInput("Message cant be longer than 120 characters!");
//        }
//        try {
//                Integer.parseInt(receiver);
//        } catch (NumberFormatException e){
//            throw new InvalidSMSInput("Receivers phone number is not a number!");
//        }
//
//
//
//        ////////////
//        List<String> smsContainer = new LinkedList<>();
//        smsContainer.add(receiver);
//        smsContainer.add(title);
//        smsContainer.add(message);
//        return smsContainer;
//        ///////////
//    }

    public List<String> send(SMSReceiver receiver, String title, String message) throws InvalidSMSInput {
        message = message.trim();

        if(isNullOrEmpty(title) || isNullOrEmpty(message)){
            throw new InvalidSMSInput("Receiver, title and message cant be empty!");
        }
        if (message.length()>120){
            throw new InvalidSMSInput("Message cant be longer than 120 characters!");
        }



        ////////////
        List<String> smsContainer = new LinkedList<>();
        smsContainer.add(title);
        smsContainer.add(message);
        return smsContainer;
        ///////////
    }

    private static boolean isNullOrEmpty(String str){
        try {
            return str.equals("");
        } catch (NullPointerException e){
            return true;
        }
    }
}
