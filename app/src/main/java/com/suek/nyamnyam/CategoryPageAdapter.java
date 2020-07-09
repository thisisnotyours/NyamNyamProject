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

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryPageAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<CategoryPageItems> items;

    public CategoryPageAdapter() {
    }

    public CategoryPageAdapter(Context context, ArrayList<CategoryPageItems> items) {
        this.context = context;
        this.items = items;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView= inflater.inflate(R.layout.recycler_category_page, parent, false);
        VH holder= new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;
        CategoryPageItems categoryPageItems= items.get(position);
        vh.civ.setImageResource(categoryPageItems.image);
        vh.tvName.setText(categoryPageItems.name);
        vh.tvName2.setText(categoryPageItems.name2);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }




    class VH extends RecyclerView.ViewHolder{

        CircleImageView civ;
        TextView tvName;
        TextView tvName2;

        public VH(@NonNull final View itemView) {
            super(itemView);

            this.civ= itemView.findViewById(R.id.civ);
            this.tvName= itemView.findViewById(R.id.tv_name);
            this.tvName2= itemView.findViewById(R.id.tv_name2);



//food category page 각 recyclerview 에 리스너 달아주기
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, ""+getLayoutPosition(), Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(context, VeganActivity.class);
                    intent.putExtra("civ", items.get(getLayoutPosition()).image);
                    intent.putExtra("tvName", items.get(getLayoutPosition()).name);
                    intent.putExtra("tvName2", items.get(getLayoutPosition()).name2);

                    context.startActivity(intent);
                }
            });
        }
    }

}
