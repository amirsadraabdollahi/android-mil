package com.myapplication2.controller;

import com.myapplication2.model.Email;
import com.myapplication2.model.User;

public class Processor {
    private Processor(){

    }
    private static Processor processor = new Processor();

    public static Processor getProcessor() {
        return processor;
    }

    public String sendEmail(String receiverEmail, String subject, String context){
        User receiver = User.getUserByEmail(receiverEmail);
        if(receiver == null){
            return "user with this email does't exist";
        }
        User sender = User.onlineUser;
        Email email = new Email(sender.getUsername(), receiver.getUsername(), subject, context);
        sender.sendEmail(email);
        receiver.receiveEmail(email);
        return "email sent successfully";
    }

    public String signUp(String username, String password, String email, String phoneNumber) {
        if(username.isEmpty()){
            return "fill username";
        }
        if(password.isEmpty()){
            return "fill password";
        }
        if(email.isEmpty()){
            return "fill email";
        }
        if(phoneNumber.isEmpty()){
            return "fill phoneNumber";
        }
        if(User.hasUserWithUsername(username)){
            return "user with this username exists";
        }

        new User(username, password, email, phoneNumber);
        return "you joined us ;)";

    }
}
