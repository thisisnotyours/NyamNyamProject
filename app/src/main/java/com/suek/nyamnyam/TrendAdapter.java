package com.suek.nyamnyam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TrendAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<TrendItem> items;

    public TrendAdapter(Context context, ArrayList<TrendItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View itemView= layoutInflater.inflate(R.layout.recycler_trend, parent, false);
        VH holder= new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;
        TrendItem trendItem= items.get(position);
        Glide.with(context).load(trendItem.imgUrl).into(vh.imgUrl);
        vh.title.setText(trendItem.tvTitle);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    class VH extends RecyclerView.ViewHolder{
        ImageView imgUrl;
        TextView title;

        public VH(@NonNull View itemView) {
            super(itemView);
            this.imgUrl= itemView.findViewById(R.id.iv);
            this.title= itemView.findViewById(R.id.tv_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, ""+getLayoutPosition(), Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(context, TrendActivity.class);
                    intent.putExtra("imgUrl", items.get(getLayoutPosition()).imgUrl);
                    intent.putExtra("tvTitle", items.get(getLayoutPosition()).tvTitle);
                    context.startActivity(intent);
                }
            });
        }
    }
}
