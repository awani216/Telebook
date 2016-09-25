package com.example.telebook.ChooseRoom.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telebook.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iket on 25/9/16.
 */
public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<RoomData> roomDatas=new ArrayList<>();

    public RoomAdapter(Context context) {
        this.context = context;
        this.layoutInflater=LayoutInflater.from(context);
    }

    public void setData(List roomDatas)
    {
        this.roomDatas=roomDatas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.activity_select_room_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RoomAdapter.MyViewHolder holder, int position) {
        RoomData roomData=this.roomDatas.get(position);


    }


    @Override
    public int getItemCount() {
        return this.roomDatas.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView date2,date1,date,date_1,date_2,capacity,room_name;
        private ImageView mike,proj,stage;

        public MyViewHolder(View itemView) {
            super(itemView);
            date=(TextView)itemView.findViewById(R.id.date);
            date1=(TextView)itemView.findViewById(R.id.date1);
            date2=(TextView)itemView.findViewById(R.id.date2);
            date_1=(TextView)itemView.findViewById(R.id.date_1);
            date_2=(TextView)itemView.findViewById(R.id.date_2);
            capacity=(TextView)itemView.findViewById(R.id.capacity);
            room_name=(TextView)itemView.findViewById(R.id.room_name);
//            mike=(ImageView)itemView.findViewById(R.id.mike);
        }
    }
}
