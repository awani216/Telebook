package com.example.telebook.EventPage.View;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telebook.EventPage.Model.data.EventsData;
import com.example.telebook.Helper.image_loaders.GlideImageLoader;
import com.example.telebook.Helper.image_loaders.ImageLoader;
import com.example.telebook.R;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Iket on 7/27/2016.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<EventsData> EventDataList = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;

    public Adapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
       imageLoader = new GlideImageLoader(context);
    }

    public void setData(List<EventsData> EventDataList) {
        this.EventDataList = EventDataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = layoutInflater.inflate(R.layout.activity_event_recycler, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {


        EventsData eventData = EventDataList.get(position);
        imageLoader.loadImage(eventData.getImage(), holder.iv);
        holder.tv.setText(eventData.getName());

    }

    @Override
    public int getItemCount() {
        return this.EventDataList.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;
        private ImageView iv;


        private MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.event_committee_logo);
            tv = (TextView) itemView.findViewById(R.id.event_eventname);

        }

    }
}

