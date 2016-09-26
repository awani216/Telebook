package com.example.telebook.RegisterRoom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.telebook.LogIn.RoomSelection;
import com.example.telebook.R;

/**
 * Created by Awani on 9/21/2016.
 */
public class Room_Description extends AppCompatActivity {
    EditText _name,_date,_stime,_etime,_floor,_capacity;
    String name,date,stime,etime,floor,prefRoom,capacity;
    boolean mike,stage,proj;
    CheckBox _mike,_stage,_proj;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_description);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        _capacity=(EditText)findViewById(R.id.capacity);
        _date=(EditText)findViewById(R.id.date);
        _name=(EditText)findViewById(R.id.event_name);
        _floor=(EditText)findViewById(R.id.floor);
        _mike=(CheckBox)findViewById(R.id.mike);
        _stage= (CheckBox)findViewById(R.id.stage);
        _proj=(CheckBox)findViewById(R.id.projector);
        next=(Button)findViewById(R.id.apply_filter);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=_name.getText().toString();

                Intent in=new Intent(Room_Description.this, RoomSelection.class);
                in.putExtra("name",name);
            }
        });


        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_roomSelect);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Form 1");


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.room_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}