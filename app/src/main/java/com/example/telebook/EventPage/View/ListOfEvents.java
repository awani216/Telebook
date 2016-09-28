package com.example.telebook.EventPage.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.example.telebook.EventPage.Model.RetrofitEventsProvider;
import com.example.telebook.EventPage.Model.data.EventsData;
import com.example.telebook.EventPage.Presenter.EventPresenterImpl;
import com.example.telebook.EventPage.Presenter.EventsPresenter;
import com.example.telebook.R;

import java.util.List;

public class ListOfEvents extends AppCompatActivity implements EventsInterface{

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private EventsPresenter eventsPresenter;
    private Adapter adapter;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event_description);

        toolbar = (Toolbar) findViewById(R.id.toolbar_events);
        toolbar.setTitle("Events");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_18dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewEvent);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        eventsPresenter = new EventPresenterImpl(this, new RetrofitEventsProvider());
        adapter = new Adapter(this);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        eventsPresenter.requestEvents();
    }

    @Override
    public void ShowProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    public void SetData(List<EventsData> eventDataList) {
        adapter.setData(eventDataList);
        adapter.notifyDataSetChanged();
    }
}
