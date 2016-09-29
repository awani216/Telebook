package com.example.telebook.Settings.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.telebook.Helper.SharedPrefs;
import com.example.telebook.R;

/**
 * Created by iket on 27/9/16.
 */
public class SettingsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        final CheckBox noti,vib;
        final SharedPrefs sharedPrefs=new SharedPrefs(this);
        Button default_btn=(Button)findViewById(R.id.default_button);
        noti=(CheckBox)findViewById(R.id.tune);
        vib=(CheckBox)findViewById(R.id.vibration);
        assert noti != null;
        noti.setChecked(sharedPrefs.showNotification());
        assert vib != null;
        vib.setChecked(sharedPrefs.showVibration());

        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(noti.isChecked())
                {
                    sharedPrefs.setShowNotification(true);
                }
                else
                    sharedPrefs.setShowNotification(false);
            }
        });
        assert default_btn != null;
        default_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noti.setChecked(true);
                vib.setChecked(true);
                sharedPrefs.setVibration(true);
                sharedPrefs.setShowNotification(true);
            }
        });

        vib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vib.isChecked())
                {
                    sharedPrefs.setVibration(true);
                }
                else
                    sharedPrefs.setVibration(false);
            }
        });


    }
}
