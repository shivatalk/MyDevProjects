package com.shivatalk.whatsapp;

public class CallUserList {

    private String name;
    private String date;
    private String time;
    private int count;

    public CallUserList(String name, String date, String time) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.count=1;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getCount() {
        return count;
    }
}
