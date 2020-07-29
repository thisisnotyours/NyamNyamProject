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

public class RecommendedAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<RecommendedItems> items;

    //String speech[]= new String[];

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
        vh.foodTitle.setText(recommendedItems.foodTitle);
        Glide.with(context).load(recommendedItems.foodIv).into(vh.iv);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    class VH extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView foodTitle;

        public VH(@NonNull View itemView) {
            super(itemView);

            this.iv= itemView.findViewById(R.id.iv);
            this.foodTitle= itemView.findViewById(R.id.food_title);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(context, ""+foodTitle.getText(), Toast.LENGTH_SHORT).show();

                    Intent intent= new Intent(context, RecommendedActivity.class);
                    intent.putExtra("foodIv", items.get(getLayoutPosition()).foodIv);
                    intent.putExtra("foodTitle", items.get(getLayoutPosition()).foodTitle);

                    intent.putExtra("foodTitleEng", items.get(getLayoutPosition()).foodTitleEng);
                    intent.putExtra("foodSub", items.get(getLayoutPosition()).foodSub);
                    //intent.putExtra("foodMsg", items.get(getLayoutPosition()).foodMsg);
                    intent.putExtra("foodIng", items.get(getLayoutPosition()).foodIng);
                    intent.putExtra("foodStep", items.get(getLayoutPosition()).foodStep);
                    intent.putExtra("source", items.get(getLayoutPosition()).source);

                    context.startActivity(intent);
                }
            });


        }//VH
    }//Recyclerview.ViewHolder


}//RecommendedAdapter..
