package com.example.telebook.WelcomePage;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;
import com.example.telebook.LogIn.View.Login;
import com.example.telebook.R;

public class MainActivity extends AppCompatActivity {

    int noofsize = 3;
    ViewPager myPager = null;
    int count = 0;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Button b1;

        CustomPagerAdapter adapter = new CustomPagerAdapter(MainActivity.this,noofsize);
        myPager = (ViewPager) findViewById(R.id.viewpager_home);
        myPager.setAdapter(adapter);
        myPager.setCurrentItem(0);

        // Timer for auto sliding
        timer  = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(count<=3){
                            myPager.setCurrentItem(count);
                            count++;
                        }else{
                            count = 0;
                            myPager.setCurrentItem(count);
                        }
                    }
                });
            }
        }, 500, 2000);
            b1 = (Button) findViewById(R.id.Login_home_page);
        assert b1 != null;
        b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i_login = new Intent(MainActivity.this,Login.class);
                    startActivity(i_login);
                }
            });
        }
    }

