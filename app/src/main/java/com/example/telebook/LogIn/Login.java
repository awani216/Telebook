package com.example.telebook.LogIn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.telebook.R;
import com.example.telebook.WelcomePage.MainActivity;

public class Login extends AppCompatActivity {

    Button b ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b= (Button) findViewById(R.id.button_login_login_page);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this,RoomSelection.class);
                startActivity(i);
            }
        });
    }
}
