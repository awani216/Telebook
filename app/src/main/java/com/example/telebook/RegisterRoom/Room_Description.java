package com.example.telebook.RegisterRoom;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.telebook.R;

/**
 * Created by Awani on 9/21/2016.
 */
public class Room_Description extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_description);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_roomSelect);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Form 1");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.room_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}