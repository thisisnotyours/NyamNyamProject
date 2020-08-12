package com.suek.nyamnyam;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
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

                    switch(getLayoutPosition()){
                        case 0:
                            String url= "https://www.cj.co.kr/en/k-food-life/trend-insight";
                            Intent i= new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url));
                            context.startActivity(i);
                            break;

                        case 1:
                            String url1= "https://www.90daykorean.com/korean-culture/";
                            Intent i1= new Intent(Intent.ACTION_VIEW);
                            i1.setData(Uri.parse(url1));
                            context.startActivity(i1);
                            break;

                        case 2:
                            String url2= "https://www.90daykorean.com/korean-culture/";
                            Intent i2= new Intent(Intent.ACTION_VIEW);
                            i2.setData(Uri.parse(url2));
                            context.startActivity(i2);
                            break;
                    }



                }
            });
        }
    }
}
