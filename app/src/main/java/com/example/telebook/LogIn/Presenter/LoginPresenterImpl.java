package com.example.telebook.LogIn.Presenter;

import com.example.telebook.LogIn.Model.LoginProvider;
import com.example.telebook.LogIn.Model.RetrofitLogInProvider;
import com.example.telebook.LogIn.OnLoginSent;
import com.example.telebook.LogIn.View.LogInView;
import com.example.telebook.LogIn.View.Login;
import com.example.telebook.LogIn.View.SendLoginData;

/**
 * Created by iket on 20/9/16.
 */
public class LoginPresenterImpl implements LoginPresenter{

    private LoginProvider loginProvider;
    private LogInView logInView;

    public LoginPresenterImpl(LoginProvider loginProvider, LogInView logInView) {
        this.loginProvider = loginProvider;
        this.logInView = logInView;
    }

    @Override
    public void login_send(String username, String password) {
        logInView.showProgress(true);
        loginProvider.login_send(username, password, new OnLoginSent() {
            @Override
            public void onSuccess(SendLoginData sendLoginData) {
                logInView.showProgress(false);
                logInView.onLoginVerified(sendLoginData);
            }

            @Override
            public void onFailed() {
                logInView.showProgress(false);
                logInView.showMessage("Error..Plz try in some time");

            }
        });

    }
}
