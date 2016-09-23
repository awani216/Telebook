package com.example.telebook.LogIn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.telebook.R;

/**
 * Created by Awani on 9/21/2016.
 */
public class RoomSelection extends Activity {
    String conducted_by;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_booking);

        Spinner spinner_conducted_by = (Spinner) findViewById(R.id.spinner_conducted_by);
        ArrayAdapter<CharSequence> adapter_conducted_by = ArrayAdapter.createFromResource(this,
                R.array.conducted_by_list, android.R.layout.simple_spinner_item);
        adapter_conducted_by.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_conducted_by.setAdapter(adapter_conducted_by);

        conducted_by=spinner_conducted_by.getSelectedItem().toString();

        Spinner spinner_under = (Spinner) findViewById(R.id.spinner_under);
        if(conducted_by=="Club")
        {
        ArrayAdapter<CharSequence> adapter_under = ArrayAdapter.createFromResource(this,
                R.array.club_name, android.R.layout.simple_spinner_item);
        adapter_under.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_under.setAdapter(adapter_under);
        }
        else
            if(conducted_by=="Committee")
            {
                ArrayAdapter<CharSequence> adapter_under = ArrayAdapter.createFromResource(this,
                        R.array.committee_name, android.R.layout.simple_spinner_item);
                adapter_under.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_under.setAdapter(adapter_under);
            }
        else
                if(conducted_by=="Department")
                {
                    ArrayAdapter<CharSequence> adapter_under = ArrayAdapter.createFromResource(this,
                            R.array.Department_name, android.R.layout.simple_spinner_item);
                    adapter_under.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_under.setAdapter(adapter_under);
                }
    }
}
