package com.example.telebook.LogIn.View;

/**
 * Created by iket on 20/9/16.
 */
public class SendLoginData {
    private boolean success;
    private String message;

    public SendLoginData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
