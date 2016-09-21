package com.example.telebook.LogIn;

import com.example.telebook.LogIn.View.SendLoginData;

/**
 * Created by iket on 20/9/16.
 */
public interface OnLoginSent {
    void onSuccess(SendLoginData sendLoginData);

    void onFailed();
}
