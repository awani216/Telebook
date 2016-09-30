package com.example.telebook.EventPage.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.telebook.EventPage.Model.data.EventsData;
import com.example.telebook.Helper.image_loaders.GlideImageLoader;
import com.example.telebook.Helper.image_loaders.ImageLoader;
import com.example.telebook.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



/**
 * Created by Iket on 7/27/2016.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<EventsData> EventDataList = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;

    public Adapter( Context context) {
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


        final EventsData eventData = EventDataList.get(position);
        imageLoader.loadImage(eventData.getImage(), holder.iv);
        holder.name.append(eventData.getName());
        holder.venue.append(eventData.getVenue());
        holder.date.append(eventData.getDate());
        holder.time.append(" "+eventData.getStime().substring(0,4)+" to "+eventData.getEtime().substring(0,4));
        holder.desc.setText(eventData.getDescription());

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                java.util.Calendar cal = java.util.Calendar.getInstance();
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("beginTime", cal.getTimeInMillis());
                intent.putExtra("allDay", false);
                intent.putExtra("rrule", "FREQ=DAILY");
                intent.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
                intent.putExtra("title",eventData.getName());
                holder.context2.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.EventDataList.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name,venue,date,time,desc;
        private ImageView iv;
        private Button btn;
        private Context context2;


        private MyViewHolder(View itemView) {
            super(itemView);
            context2=itemView.getContext();
            iv = (ImageView) itemView.findViewById(R.id.event_committee_logo);
            name = (TextView) itemView.findViewById(R.id.event_eventname);
            venue=(TextView)itemView.findViewById(R.id.event_eventvenue);
            date=(TextView)itemView.findViewById(R.id.event_eventdate);
            time=(TextView)itemView.findViewById(R.id.event_time);
            desc=(TextView)itemView.findViewById(R.id.description_event);
            btn=(Button)itemView.findViewById(R.id.reminder);

        }

    }
}

