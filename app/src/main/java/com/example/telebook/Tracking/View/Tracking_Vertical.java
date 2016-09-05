package com.example.telebook.Tracking.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.telebook.R;
import com.example.telebook.Tracking.Model.data.TrackData;

import java.util.ArrayList;
import java.util.List;

public class Tracking_Vertical extends AppCompatActivity {


    private RecyclerView recyclerViewTracking;

    private TrackAdapter trackAdapter;
    private  LinearLayoutManager linearLayoutManager;

    private List<TrackData> mDataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking__vertical);
        linearLayoutManager= new LinearLayoutManager(this);

        recyclerViewTracking = (RecyclerView) findViewById(R.id.recyclerViewTracking);
        recyclerViewTracking.setLayoutManager(linearLayoutManager);
        recyclerViewTracking.setHasFixedSize(true);
//        initView();
    }
}
