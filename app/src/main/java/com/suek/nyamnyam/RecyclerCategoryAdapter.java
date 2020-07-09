package com.suek.nyamnyam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerCategoryAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Item> items;

    public RecyclerCategoryAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView= inflater.inflate(R.layout.recycler_food_category, parent, false);
        VH holder= new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;
        Item item= items.get(position);
        vh.civ.setImageResource(item.img);
        vh.tvName.setText(item.name);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    class VH extends RecyclerView.ViewHolder{

        CircleImageView civ;
        TextView tvName;

        public VH(@NonNull View itemView) {
            super(itemView);

            this.civ= itemView.findViewById(R.id.civ);
            this.tvName= itemView.findViewById(R.id.tv_name);
        }
    }


}//CategoryAdapter
