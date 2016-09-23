package com.example.telebook.SplashScreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.telebook.Helper.Sample;
import com.example.telebook.LogIn.LoginTest;
import com.example.telebook.LogIn.View.Login;
import com.example.telebook.Tracking.View.Tracking_Vertical;
import com.example.telebook.WelcomePage.MainActivity;
import com.example.telebook.R;
import com.tt.whorlviewlibrary.WhorlView;

import me.wangyuwei.particleview.ParticleView;

/**
 * Created by Awani on 8/30/2016.
 */
public class SplashScreen extends Activity{
    private ParticleView anime_text;

    private static int SPLASH_TIME_OUT = 8000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.screen_splash);

        anime_text=(ParticleView)findViewById(R.id.anim_text);
        anime_text.startAnim();

        anime_text.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {

            }
        });

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this,Sample.class);
                startActivity(i);

                finish();

            }
        }, SPLASH_TIME_OUT);
    }
}
