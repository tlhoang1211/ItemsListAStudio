package com.example.callapi.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.callapi.R;
import com.example.callapi.model.Item;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter {
    private final Activity activity;
    private final List<Item> listNew;

    public NewsAdapter(Activity activity, List<Item> listNew) {
        this.activity = activity;
        this.listNew = listNew;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_news, parent, false);
        return new NewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewHolder productHolder = (NewHolder) holder;
        Item model = listNew.get(position);
        productHolder.imgCover.setImageResource(model.getImage());
        productHolder.titleList.setText(model.getTitle());
        productHolder.dateList.setText(model.getDate());
    }

    @Override
    public int getItemCount() {
        return listNew.size();
    }

    public static class NewHolder extends RecyclerView.ViewHolder {
        ImageView imgCover;
        TextView titleList;
        TextView dateList;

        public NewHolder(@NonNull View itemView) {
            super(itemView);
            imgCover = itemView.findViewById(R.id.imgCover);
            titleList = itemView.findViewById(R.id.titleList);
            dateList = itemView.findViewById(R.id.dateList);
        }
    }
}
