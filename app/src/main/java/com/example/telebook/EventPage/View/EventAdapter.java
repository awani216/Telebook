package com.example.telebook.EventPage.View;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telebook.EventPage.Model.data.EventData;
import com.example.telebook.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awani on 9/26/2016.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<EventData> eventDatas = new ArrayList<>();

    public EventAdapter(Context context)
    {
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.activity_event_recycler, parent, false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
       private ImageView iv;
       private TextView tv;
        public EventViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cardview_event_page);
            iv = (ImageView) itemView.findViewById(R.id.event_committee_logo);
            tv = (TextView) itemView.findViewById(R.id.event_committee_description);
        }
    }
}
