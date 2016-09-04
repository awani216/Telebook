package com.example.telebook;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Button b1;

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_home);
        viewPager.setAdapter(new CustomPagerAdapter(this));
            b1 = (Button) findViewById(R.id.Login_home_page);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i_login = new Intent(MainActivity.this,Login.class);
                    startActivity(i_login);
                }
            });

        }
    }

