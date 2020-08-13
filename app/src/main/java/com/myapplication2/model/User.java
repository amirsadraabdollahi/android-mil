package com.myapplication2.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class User {
    public static User onlineUser;
    public static ArrayList<String> usersUserName = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private ArrayList<Email> receivedEmails;
    private ArrayList<Email> sentEmails;

    public User(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sentEmails = new ArrayList<>();
        this.receivedEmails = new ArrayList<>();
        users.add(this);
        usersUserName.add(this.username);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public static boolean hasUserWithUsername(String username) {
        return usersUserName.contains(username);
    }

    public static boolean correctPassword(String username, String password){
        if(Objects.requireNonNull(User.getUserByUsername(username)).getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public static User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static User getUserByEmail(String email){
        for (User user : User.users) {
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public static void login(String username) {
        onlineUser = User.getUserByUsername(username);
    }

    public void receiveEmail(Email email) {
        this.receivedEmails.add(email);
    }

    public void sendEmail(Email email) {
       User receiver = User.getUserByUsername(email.getReceiver());
        if (receiver != null) {
            receiver.receiveEmail(email);
        }
        this.sentEmails.add(email);
    }

}
