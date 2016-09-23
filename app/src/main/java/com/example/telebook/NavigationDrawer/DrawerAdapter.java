package com.example.telebook.NavigationDrawer;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telebook.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by iket on 22/9/16.
 */
public class DrawerAdapter extends RecyclerView.Adapter {

    private static final int VIEW_HEADER = 1;
    private static final int VIEW_BODY = 2;
    List<NavDrawerItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
    private List<Integer> iconList = new ArrayList<>();

    public DrawerAdapter(Context context, List<NavDrawerItem> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
//        sharedPrefs = new SharedPrefs(context);
        getMockList();
    }

    @Override
    public int getItemViewType(int position) {

            return VIEW_BODY;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {

            case VIEW_BODY:
                View view1 = inflater.inflate(R.layout.drawer_item, parent, false);
                return new TitleViewHolder(view1);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        NavDrawerItem current = data.get(position);

                TitleViewHolder viewHolder = (TitleViewHolder) holder;
                viewHolder.title.setText(current.getTitle());
                viewHolder.icon.setImageResource(iconList.get(position));


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private void getMockList() {
        iconList.add(R.drawable.ecell_logo);
        iconList.add(R.drawable.ecell_logo);
        iconList.add(R.drawable.ecell_logo);
        iconList.add(R.drawable.ecell_logo);
        iconList.add(R.drawable.ecell_logo);
        iconList.add(R.drawable.ecell_logo);
        iconList.add(R.drawable.ecell_logo);

    }

    class TitleViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;

        public TitleViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            icon = (ImageView) itemView.findViewById(R.id.icon);
        }
    }


}
