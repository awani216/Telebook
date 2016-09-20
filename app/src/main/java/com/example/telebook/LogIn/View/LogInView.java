package com.example.telebook.LogIn.View;

/**
 * Created by iket on 20/9/16.
 */
public interface LogInView {
    void showProgress(boolean visible);
    void showMessage(String message);
    void onLoginVerified(SendLoginData sendLoginData);

}
