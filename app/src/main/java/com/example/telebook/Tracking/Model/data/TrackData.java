package com.example.telebook.Tracking.Model.data;

/**
 * Created by Iket on 9/5/2016.
 */
public class TrackData {
    private String designation;
    private String name;
    private String message;
    private int result;

    public TrackData(String designation, String name, String message, int result) {
        this.designation = designation;
        this.name = name;
        this.message = message;
        this.result = result;
    }

    public String getDesignation() {
        return designation;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public int getResult() {
        return result;
    }
}
