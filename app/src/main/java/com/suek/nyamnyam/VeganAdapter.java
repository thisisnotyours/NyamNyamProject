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

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class VeganAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<VeganItem> items;

    public VeganAdapter(Context context, ArrayList<VeganItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View itemView= layoutInflater.inflate(R.layout.recycler_vegan, parent, false);
        VH holder= new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;
        VeganItem veganItem= items.get(position);
        vh.civ.setImageResource(veganItem.civ);
        vh.tvName.setText(veganItem.tvName);
        vh.tvName2.setText(veganItem.tvName2);
        vh.tvName3.setText(veganItem.tvName3);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }




    class VH extends RecyclerView.ViewHolder{

        CircleImageView civ;
        TextView tvName;
        TextView tvName2;
        TextView tvName3;
     /*참조변수 이름바꾸기... 헷갈림*/

        public VH(@NonNull final View itemView) {
            super(itemView);

            this.civ= itemView.findViewById(R.id.civ);
            this.tvName= itemView.findViewById(R.id.tv_name);
            this.tvName2= itemView.findViewById(R.id.tv_name2);
            this.tvName3= itemView.findViewById(R.id.tv_name3);




            //클릭리스너- Recipe Activity 로 이동
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, ""+getLayoutPosition(), Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(context, RecipeActivity.class);
                    intent.putExtra("civ", items.get(getLayoutPosition()).civ);
                    intent.putExtra("tvName", items.get(getLayoutPosition()).tvName);
                    intent.putExtra("tvName2", items.get(getLayoutPosition()).tvName2);
                    intent.putExtra("tvName3", items.get(getLayoutPosition()).tvName3);

                    context.startActivity(intent);
                }
            });


        }// VH- itemView
    }// VH- RecyclerView


    }

