package com.example.telebook.History.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telebook.R;
import com.vipul.hp_hp.timelineview.TimelineView;

import java.util.List;

/**
 * Created by iket on 29/9/16.
 */
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<HistoryData> historyDatas;

    public HistoryAdapter(Context context) {
        this.context=context;
        layoutInflater=LayoutInflater.from(context);

    }
    public void setData(List<HistoryData> historyDatas)
    {
        this.historyDatas=historyDatas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.activity_show_history_recycler_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HistoryData historyData=historyDatas.get(position);

        holder.name.setText(historyData.getName());
        holder.date.setText(historyData.getDate());
        holder.status.setText(historyData.getStatus());

    }

    @Override
    public int getItemCount() {
        return historyDatas.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name,date,status;

        private MyViewHolder(View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.event_committee_logo);
            name=(TextView)itemView.findViewById(R.id.history_roomname);
            date=(TextView)itemView.findViewById(R.id.history_daterequested);
            status=(TextView)itemView.findViewById(R.id.history_status);


        }

    }
}

