package com.example.telebook.RegisterRoom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.telebook.ChooseRoom.View.SelectRoom;
import com.example.telebook.LogIn.RoomSelection;
import com.example.telebook.R;

/**
 * Created by Awani on 9/21/2016.
 */
public class Room_Description extends AppCompatActivity {
    EditText _name,_date,_stime,_etime,_floor,_capacity;
    String name,date,stime,etime,floor,prefRoom,capacity;
    boolean mike=false,stage=false,proj=false;
    int msp=0;
    CheckBox _mike,_stage,_proj;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_description);
         msp=0;
         final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        _capacity=(EditText)findViewById(R.id.capacity);
        _date=(EditText)findViewById(R.id.date);
        _name=(EditText)findViewById(R.id.event_name);
        _floor=(EditText)findViewById(R.id.floor);
        _mike=(CheckBox)findViewById(R.id.mike);
        _stime=(EditText)findViewById(R.id.time);
        _etime=(EditText)findViewById(R.id.etime);
        _stage= (CheckBox)findViewById(R.id.stage);
        _proj=(CheckBox)findViewById(R.id.projector);
        next=(Button)findViewById(R.id.apply_filter);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Response","abc");
                name=_name.getText().toString();
                if(_mike.isChecked())
                    msp+=1;
                if(_proj.isChecked())
                    msp+=2;
                if(_stage.isChecked())
                    msp+=4;
                name=_name.getText().toString();
                date=_date.getText().toString();
                stime=_stime.getText().toString();
                etime=_etime.getText().toString();
                floor=_floor.getText().toString();
                prefRoom=spinner.getSelectedItem().toString();
                capacity=_capacity.getText().toString();

                Intent in=new Intent(Room_Description.this, SelectRoom.class);
                in.putExtra("name",name);
                in.putExtra("date",date);
                in.putExtra("stime",stime);
                in.putExtra("floor",floor);
                in.putExtra("etime",etime);
                in.putExtra("prefRoom",prefRoom);
                in.putExtra("capacity",capacity);
                in.putExtra("msp",msp);
                startActivity(in);
            }
        });


//        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_roomSelect);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Form 1");


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.room_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}