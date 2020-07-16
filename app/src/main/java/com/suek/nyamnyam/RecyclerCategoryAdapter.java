package com.suek.nyamnyam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

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
        View itemView= inflater.inflate(R.layout.recycler_category, parent, false);
        VH holder= new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;
        Item item= items.get(position);
        Glide.with(context).load(item.imgUrl).into(vh.civ);
        vh.tvName.setText(item.name);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    class VH extends RecyclerView.ViewHolder{

        CircleImageView civ;
        TextView tvName;

        public VH(@NonNull final View itemView) {
            super(itemView);
            this.civ= itemView.findViewById(R.id.civ);
            this.tvName= itemView.findViewById(R.id.tv_name);



            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context, ""+tvName.getText(), Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(context, VeganActivity.class);                   //다시하기.....--> VeganActivity로..
                    intent.putExtra("image", "category recycler image");
                    intent.putExtra("title", items.get(getLayoutPosition()).name);
                    context.startActivity(intent);
                }
            });*/


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(context, VeganActivity.class);
                    intent.putExtra("foodTitle", items.get(getLayoutPosition()).name);
                    intent.putExtra("civ", items.get(getLayoutPosition()).imgUrl);
                    context.startActivity(intent);
                }
            });
        }
    }


}//CategoryAdapter
