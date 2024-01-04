package com.shivatalk.whatsapp;

public class ChatUser {

    private String name;
    private String last_msg;
    private String date;

    public ChatUser(String name, String last_msg,String date) {
        this.name = name;
        this.last_msg = last_msg;
        this.date=date;
    }

    public String getName() {
        return name;
    }

    public String getLast_msg() {
        return last_msg;
    }

    public String getDate() {
        return date;
    }
}
