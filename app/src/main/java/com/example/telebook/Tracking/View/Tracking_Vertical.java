package com.example.telebook.Tracking.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.telebook.R;
import com.example.telebook.Tracking.Model.RetrofitTrackingProvider;
import com.example.telebook.Tracking.Model.data.TrackData;
import com.example.telebook.Tracking.Presenter.TrackPresenter;
import com.example.telebook.Tracking.Presenter.TrackPresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class Tracking_Vertical extends AppCompatActivity implements TrackViewInterface {

    private TrackPresenter trackPresenter;
    private RecyclerView recyclerViewTracking;
    private ProgressBar progressBar;
    private TrackAdapter trackAdapter;
    private  LinearLayoutManager linearLayoutManager;

    private List<TrackData> mDataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking__vertical);
        linearLayoutManager= new LinearLayoutManager(this);
        progressBar=(ProgressBar)findViewById(R.id.progressbar_tracking);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_tracking);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tracking");

        trackPresenter = new TrackPresenterImpl(this,new RetrofitTrackingProvider());
        trackAdapter = new TrackAdapter(this);

        recyclerViewTracking = (RecyclerView) findViewById(R.id.recyclerViewTracking);
        recyclerViewTracking.setLayoutManager(linearLayoutManager);
        recyclerViewTracking.setAdapter(trackAdapter);
        trackPresenter.getTracking(1,1);
    }

    @Override
    public void showLoading(boolean visible) {
    if(visible)
    {
        progressBar.setVisibility(View.VISIBLE);
    }
        else
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onTrackingRecieved(List<TrackData> trackDatas) {
        TrackData t;
        for(int i=0;i<trackDatas.size();i++)
        {
            t=trackDatas.get(i);
            Log.d("Resp",""+ t.getDesignation()+t.getName()+t.getMessage()+t.getResult());
        }
        trackAdapter.setData(trackDatas);
        trackAdapter.notifyDataSetChanged();
    }



    @Override
    public void showMessage() {

    }
}
