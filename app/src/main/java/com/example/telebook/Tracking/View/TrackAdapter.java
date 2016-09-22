package com.example.telebook.Tracking.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telebook.R;
import com.example.telebook.Tracking.Model.data.TrackData;

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
        myViewHolder.name.setText(trackData.getName());
        myViewHolder.designation.setText(trackData.getDesignation());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name,designation,status;

        private MyViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            designation=(TextView)itemView.findViewById(R.id.designation);

        }

    }


}
