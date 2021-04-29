package com.suek.nyamnyam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Grid_mypost_Adapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Grid_mypost_Item> items;

    public Grid_mypost_Adapter(Context context, ArrayList<Grid_mypost_Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View itemView= layoutInflater.inflate(R.layout.recycler_grid_mypost, parent, false);
        VH holder= new VH (itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;
        Grid_mypost_Item gridItem= items.get(position);
        vh.tvTitle.setText(gridItem.title);
        vh.tvDate.setText(gridItem.date);
        Glide.with(context).load(gridItem.file).into(vh.iv);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }




    class VH extends RecyclerView.ViewHolder{

        TextView tvDate;
        TextView tvTitle;
        ImageView iv;

        public VH(@NonNull View itemView) {
            super(itemView);

            tvDate= itemView.findViewById(R.id.tv_date);
            tvTitle= itemView.findViewById(R.id.tv_title);
            iv= itemView.findViewById(R.id.iv);
        }
    }
}
