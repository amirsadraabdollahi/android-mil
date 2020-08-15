package com.myapplication2.model;

public class Email {
    private String sender;
    private String receiver;
    private String subject;
    private String context;
    private String url;

    public Email(String sender, String receiver, String subject, String context) {
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.context = context;
        this.url="";
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSubject() {
        return subject;
    }

    public String getContext() {
        return context;
    }


}

