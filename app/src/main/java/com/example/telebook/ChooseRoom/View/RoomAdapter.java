package com.example.telebook.ChooseRoom.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telebook.Helper.image_loaders.GlideImageLoader;
import com.example.telebook.Helper.image_loaders.ImageLoader;
import com.example.telebook.R;
import com.example.telebook.RegisterRoom.RoomBook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iket on 25/9/16.
 */
public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<RoomData> roomDatas=new ArrayList<>();
    private ImageLoader imageLoader;

    public RoomAdapter(Context context) {
        this.context = context;
        this.layoutInflater=LayoutInflater.from(context);
        imageLoader = new GlideImageLoader(context);
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
    public void onBindViewHolder(final RoomAdapter.MyViewHolder holder, int position) {
        final RoomData roomData=this.roomDatas.get(position);

        holder.room_name.setText(roomData.getName());
        holder.capacity.setText("Capacity : "+roomData.getCapacity());
        imageLoader.loadImage(roomData.getImage(),holder.image_room);
        holder.date.setText(roomData.getDate0().substring(0,2));
        if(roomData.getDate0().charAt(8)=='0')

        {
            holder.available.setImageResource(R.color.red);
            Log.d("Res","Red");
            holder.date.setTextColor(context.getResources().getColor(R.color.red));
        }
        else {
            Log.d("Res","green");
            holder.available.setImageResource(R.color.green);
            holder.date.setTextColor(context.getResources().getColor(R.color.green));
        }

        holder.date_1.setText(roomData.getDate1().substring(0,2));
        if(roomData.getDate1().charAt(8)=='0')
            holder.date_1.setTextColor(context.getResources().getColor(R.color.red));
        else
            holder.date_1.setTextColor(context.getResources().getColor(R.color.green));

        holder.date1.setText(roomData.getDate_1().substring(0,2));
        if(roomData.getDate_1().charAt(8)=='0')
            holder.date1.setTextColor(context.getResources().getColor(R.color.red));
        else
            holder.date1.setTextColor(context.getResources().getColor(R.color.green));

        holder.date_2.setText(roomData.getDate2().substring(0,2));
        if(roomData.getDate2().charAt(8)=='0')
            holder.date_2.setTextColor(context.getResources().getColor(R.color.red));
        else
            holder.date_2.setTextColor(context.getResources().getColor(R.color.green));

        holder.date2.setText(roomData.getDate_2().substring(0,2));
        if(roomData.getDate_2().charAt(8)=='0')
            holder.date2.setTextColor(context.getResources().getColor(R.color.red));
        else
            holder.date2.setTextColor(context.getResources().getColor(R.color.green));

        if(roomData.getMike()==0)
        {
            holder.mike.setVisibility(View.GONE);
        }
        else
            holder.mike.setImageResource(R.drawable.mike);

        Log.d("Res","mike= "+roomData.getMike()+"  proj="+roomData.getProj()+"  stage= "+roomData.getStage());
        if(roomData.getProj()==0)
        {
            holder.proj.setVisibility(View.GONE);
        }
        else
            holder.proj.setImageResource(R.drawable.projector);

        if(roomData.getStage()==0)
        {
            holder.stage.setVisibility(View.GONE);
        }
        else
            holder.stage.setImageResource(R.drawable.stage);
        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(holder.context2, RoomBook.class);
                in.putExtra("event_name",roomData.getEventname());
                in.putExtra("date",roomData.getDate0());
                in.putExtra("venue",roomData.getName());

                holder.context2.startActivity(in);
            }
        });

    }


    @Override
    public int getItemCount() {
        return this.roomDatas.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView date2,date1,date,date_1,date_2,capacity,room_name;
        private ImageView mike,proj,stage,available,image_room;
        Button book;
        private Context context2;

        public MyViewHolder(View itemView) {
            super(itemView);
            context2=itemView.getContext();
            book=(Button)itemView.findViewById(R.id.book);
            date=(TextView)itemView.findViewById(R.id.date);
            date1=(TextView)itemView.findViewById(R.id.date1);
            date2=(TextView)itemView.findViewById(R.id.date2);
            date_1=(TextView)itemView.findViewById(R.id.date_1);
            date_2=(TextView)itemView.findViewById(R.id.date_2);
            capacity=(TextView)itemView.findViewById(R.id.capacity);
            room_name=(TextView)itemView.findViewById(R.id.room_name);
            mike=(ImageView)itemView.findViewById(R.id.iv_mike);
            image_room=(ImageView)itemView.findViewById(R.id.image_room);
            proj=(ImageView)itemView.findViewById(R.id.iv_proj);
            stage=(ImageView)itemView.findViewById(R.id.iv_stage);
            available=(ImageView)itemView.findViewById(R.id.marker);

        }
    }
}
