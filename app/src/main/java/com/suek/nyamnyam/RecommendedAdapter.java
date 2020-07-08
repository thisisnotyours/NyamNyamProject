package com.suek.nyamnyam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<RecommendedItems> items;

    public RecommendedAdapter(Context context, ArrayList<RecommendedItems> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView= inflater.inflate(R.layout.recycler_recommended, parent, false);
        VH holder= new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;
        RecommendedItems recommendedItems= items.get(position);
        vh.tvName.setText(recommendedItems.tvName);
        vh.iv.setImageResource(recommendedItems.img);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    class VH extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tvName;

        public VH(@NonNull View itemView) {
            super(itemView);

            this.iv= itemView.findViewById(R.id.iv);
            this.tvName= itemView.findViewById(R.id.tv_name);
        }
    }


}//RecommendedAdapter..
