package com.example.telebook.LogIn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.telebook.Home.View.Sample;
import com.example.telebook.R;
import com.example.telebook.Tracking.View.Tracking_Vertical;

public class LoginTest extends AppCompatActivity {

    Button b,b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b= (Button) findViewById(R.id.login_button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginTest.this,Sample.class);
                startActivity(i);
            }
        });
        b1=(Button)findViewById(R.id.test1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(LoginTest.this, Tracking_Vertical.class);
                startActivity(in);
            }
        });
    }
}
