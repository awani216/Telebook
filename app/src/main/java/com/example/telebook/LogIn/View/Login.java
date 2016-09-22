package com.example.telebook.LogIn.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.telebook.LogIn.Model.RetrofitLogInProvider;
import com.example.telebook.LogIn.Presenter.LoginPresenter;
import com.example.telebook.LogIn.Presenter.LoginPresenterImpl;
import com.example.telebook.R;
import com.example.telebook.WelcomePage.MainActivity;
import com.tt.whorlviewlibrary.WhorlView;

public class Login extends AppCompatActivity implements LogInView {
    EditText user_name,password;
    Button login_button;
    String name,pswrd;
    LoginPresenter loginPresenter;
    WhorlView whorlView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user_name=(EditText)findViewById(R.id.user_name);
        password=(EditText)findViewById(R.id.password);
        whorlView=(WhorlView)findViewById(R.id.whorl_login);
        whorlView.setVisibility(View.INVISIBLE);
//        progressBar=(ProgressBar)findViewById(R.id.progreessbar_login);
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
            whorlView.start();
        }
        else
            whorlView.stop();

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(Login.this, ""+message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginVerified(SendLoginData sendLoginData) {
        if(sendLoginData.isSuccess())
        {
            Intent next=new Intent(Login.this, MainActivity.class);
            startActivity(next);
            finish();
        }
        else
            showMessage(sendLoginData.getMessage());
    }
}
