package com.example.telebook.LogIn.Model;

import com.example.telebook.LogIn.OnLoginSent;

/**
 * Created by iket on 20/9/16.
 */
public interface LoginProvider {
    void login_send(String username, String password, OnLoginSent onLoginSent);

}
