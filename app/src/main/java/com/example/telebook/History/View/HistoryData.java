package com.example.telebook.History.View;

/**
 * Created by iket on 25/9/16.
 */
public class HistoryData {

    private String name,date,status,img;

    public HistoryData(String name, String date, String status, String img) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getImg() {
        return img;
    }
}

