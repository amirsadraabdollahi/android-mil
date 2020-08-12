package com.myapplication2.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class User {
    public static String onlineUser;
    public static ArrayList<String> usersUserName = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private HashMap<String, ArrayList<String>> receivedEmails;
    private HashMap<String, ArrayList<String>> sentEmails;

    public User(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.receivedEmails = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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

    public static void login(String username) {
        onlineUser = username;
    }

    public void receiveEmail(String sender, String emailText) {
        if (this.receivedEmails.containsKey(sender)) {
            receivedEmails.get(sender).add(emailText);
            return;
        }
        ArrayList<String> box = new ArrayList<>();
        box.add(emailText);
        receivedEmails.put(sender, box);
    }

    public void sendEmail(String receiver, String emailText) {
        User user = User.getUserByUsername(receiver);
        if (user == null) throw new AssertionError();//khaye bagher
        user.receiveEmail(this.username, emailText);
        if (this.sentEmails.containsKey(receiver)) {
            sentEmails.get(receiver).add(emailText);
            return;
        }
        ArrayList<String> box = new ArrayList<>();
        box.add(emailText);
        sentEmails.put(receiver, box);
    }

}