package com.example.telebook.ChooseRoom.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_room);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerViewSelectRoom);
        progressBar=(ProgressBar)findViewById(R.id.progressbar_selectroom);

        linearLayoutManager= new LinearLayoutManager(this);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_roomSelect);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Select Room");

        selectionPresenter = new SelectionPresenterImpl(this, new RetrofitOptionsProvider()) {
        };
        roomAdapter=new RoomAdapter(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(roomAdapter);

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

    }
}
