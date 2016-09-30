package com.example.telebook.LogIn.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.telebook.Helper.SharedPrefs;
import com.example.telebook.Home.View.Sample;
import com.example.telebook.LogIn.Model.RetrofitLogInProvider;
import com.example.telebook.LogIn.Presenter.LoginPresenter;
import com.example.telebook.LogIn.Presenter.LoginPresenterImpl;
import com.example.telebook.R;

import java.util.Calendar;

public class Login extends AppCompatActivity implements LogInView {
    EditText user_name,password;
    Button login_button,b1;
    String name,pswrd;
    LoginPresenter loginPresenter;
    ProgressBar progressBar;
    SharedPrefs sharedPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreference = new SharedPrefs(this);

        user_name=(EditText)findViewById(R.id.user_name);
        password=(EditText)findViewById(R.id.password);
        progressBar=(ProgressBar)findViewById(R.id.progressbar_login);
        progressBar.setVisibility(View.INVISIBLE);
        b1=(Button)findViewById(R.id.test1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreference.setUsername("nit user");

                Intent in = new Intent(Login.this,Sample.class);
                startActivity(in);
                finish();
            }
        });

        login_button=(Button)findViewById(R.id.login_button);
        loginPresenter=new LoginPresenterImpl(new RetrofitLogInProvider(),this);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=user_name.getText().toString();
                pswrd=password.getText().toString();
                loginPresenter.login_send(name,pswrd);
            }
        });

    }

    @Override
    public void showProgress(boolean visible) {
        if(visible)
        {
            progressBar.setVisibility(View.VISIBLE);
        }
        else
            progressBar.setVisibility(View.INVISIBLE);

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(Login.this, ""+message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginVerified(SendLoginData sendLoginData) {
        if(sendLoginData.isSuccess())
        {
//            sharedPreference.setUserid(sendLoginData.getId());
            sharedPreference.setUsername(name);
            sharedPreference.setKeyIsLoggedIn(true);
            sharedPreference.setKeyUserId(sendLoginData.getId());
            Intent next=new Intent(Login.this, Sample.class);
            startActivity(next);
            finish();
        }
        else
            showMessage(sendLoginData.getMessage());
    }
}
