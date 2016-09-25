package com.example.telebook.Tracking.View;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telebook.R;
import com.example.telebook.Tracking.Model.data.TrackData;
import com.vipul.hp_hp.timelineview.TimelineView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iket on 9/5/2016.
 */
public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.MyViewHolder>{
    private Context context;
    private LayoutInflater layoutInflater;
    private List<TrackData> trackDatas = new ArrayList<>();


    public TrackAdapter(Context context) {
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
    }

    public void setData(List<TrackData> trackDatas) {
        this.trackDatas = trackDatas;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.activity_tracking__recycler__item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, int position) {
        TrackData trackData=trackDatas.get(position);

            Log.d("Respo",""+ trackData.getDesignation()+trackData.getName()+trackData.getMessage()+trackData.getResult());

        myViewHolder.name.setText(trackData.getName());
        myViewHolder.designation.setText(trackData.getDesignation());
        if(trackData.getResult()>=1) {
            myViewHolder.timelineView.setMarker(context.getResources().getDrawable(R.drawable.green_marker));
        }
        else if(trackData.getResult()==0)
            myViewHolder.timelineView.setMarker(context.getResources().getDrawable(R.drawable.gray_marker));
        else
            myViewHolder.timelineView.setMarker(context.getResources().getDrawable(R.drawable.red_marker));
    }

    @Override
    public int getItemCount() {
        return this.trackDatas.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name,designation,status;
        private TimelineView timelineView;

        private MyViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            designation=(TextView)itemView.findViewById(R.id.designation);
            timelineView=(TimelineView)itemView.findViewById(R.id.time_marker);

        }

    }


}
