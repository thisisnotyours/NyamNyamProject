package com.suek.nyamnyam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FoodCultureAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<FoodCultureItem> items;

    public FoodCultureAdapter(Context context, ArrayList<FoodCultureItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View itemView= layoutInflater.inflate(R.layout.recycler_food_culture, parent, false);
        VH holder= new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;
        FoodCultureItem cultureItem= items.get(position);
        vh.tvTitle.setText(cultureItem.title);
        Glide.with(context).load(cultureItem.file).into(vh.iv);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    class VH extends RecyclerView.ViewHolder{

        ImageView iv;
        TextView tvTitle;

        public VH(@NonNull View itemView) {
            super(itemView);

            iv= itemView.findViewById(R.id.iv);
            tvTitle= itemView.findViewById(R.id.tv_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(context, FoodCulture2Activity.class);
                    intent.putExtra("title", items.get(getLayoutPosition()).title);
                    intent.putExtra("file", items.get(getLayoutPosition()).file);

                    intent.putExtra("sub", items.get(getLayoutPosition()).sub);
                    intent.putExtra("source", items.get(getLayoutPosition()).source);
                    intent.putExtra("msg", items.get(getLayoutPosition()).msg);
                    context.startActivity(intent);
                }
            });
        }
    }
}
