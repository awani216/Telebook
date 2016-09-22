package com.example.telebook.LogIn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.telebook.Home.View.HomePage;
import com.example.telebook.R;

public class LoginTest extends AppCompatActivity {

    Button b,b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b= (Button) findViewById(R.id.login_button);
        b1=(Button)findViewById(R.id.test1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginTest.this,RoomSelection.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(LoginTest.this,HomePage.class);
                startActivity(in);
            }
        });
    }
}
