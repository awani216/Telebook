package com.example.telebook.LogIn.View;

/**
 * Created by iket on 20/9/16.
 */
public class SendLoginData {
    private boolean success;
    private String message;
    private int id;



    public SendLoginData(boolean success, String message, int id) {

        this.success = success;
        this.message = message;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
