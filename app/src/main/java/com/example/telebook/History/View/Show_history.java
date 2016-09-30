package com.example.telebook.History.View;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.example.telebook.Helper.SharedPrefs;
import com.example.telebook.History.Presenter.HistoryPresenter;
import com.example.telebook.R;

public class Show_history extends AppCompatActivity {
    private LinearLayoutManager linearLayoutManager;
    private ProgressBar progressBar;
    private HistoryAdapter historyAdapter;
    private HistoryPresenter historyPresenter;
    private SharedPrefs sharedPrefs;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_history);
//        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_tracking);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Tracking");
//        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_18dp);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
        progressBar=(ProgressBar)findViewById(R.id.progressbar_history);
        sharedPrefs=new SharedPrefs(this);
        int uid=sharedPrefs.getKeyUserId();
        historyAdapter=new HistoryAdapter(this);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerViewHistory);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(historyAdapter);




    }
}
