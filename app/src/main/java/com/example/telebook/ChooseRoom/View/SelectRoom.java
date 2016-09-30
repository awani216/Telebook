package com.example.telebook.ChooseRoom.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.telebook.ChooseRoom.Model.RetrofitOptionsProvider;
import com.example.telebook.ChooseRoom.Presenter.SelectionPresenter;
import com.example.telebook.ChooseRoom.Presenter.SelectionPresenterImpl;
import com.example.telebook.R;
import com.example.telebook.Tracking.Model.RetrofitTrackingProvider;
import com.example.telebook.Tracking.Presenter.TrackPresenterImpl;
import com.example.telebook.Tracking.View.TrackAdapter;

import java.util.List;

public class SelectRoom extends AppCompatActivity implements SelectRoomInterface{


    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private RoomAdapter roomAdapter;
    private SelectionPresenter selectionPresenter;
    private LinearLayoutManager linearLayoutManager;
    String name,date,stime,etime,floor,prefRoom,capacity;
    boolean mike,stage,proj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_room);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerViewSelectRoom);
        progressBar=(ProgressBar)findViewById(R.id.progressbar_selectroom);
        name=getIntent().getExtras().getString("name");
        date=getIntent().getExtras().getString("date");
        capacity=getIntent().getExtras().getString("capacity");
        prefRoom=getIntent().getExtras().getString("prefRoom");
        stime=getIntent().getExtras().getString("stime");
        etime=getIntent().getExtras().getString("etime");
        floor=getIntent().getExtras().getString("floor");

        int msp=getIntent().getExtras().getInt("msp");

        linearLayoutManager= new LinearLayoutManager(this);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_selectroom);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Select Room");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_18dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        selectionPresenter = new SelectionPresenterImpl(this, new RetrofitOptionsProvider());
        roomAdapter=new RoomAdapter(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(roomAdapter);
        selectionPresenter.reqRooms(name,date,floor,stime,etime,capacity,prefRoom,msp);

    }

    @Override
    public void showLoading(boolean visible) {
        if(visible)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onRoomsRecieved(List<RoomData> roomDatas) {
            roomAdapter.setData(roomDatas);
        roomAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage() {
        Toast.makeText(SelectRoom.this, "Error", Toast.LENGTH_SHORT).show();

    }

}
