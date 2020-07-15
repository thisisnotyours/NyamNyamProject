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
        //vh.civ.setImageResource(categoryPageItems.civ);
        Glide.with(context).load(categoryPageItems.civ).into(vh.civ);
        vh.tvFoodTitle.setText(categoryPageItems.foodTitle);  //foodTitle - CategoryPageItems 에 있는
        vh.tvFoodSub.setText(categoryPageItems.foodSub);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }




    class VH extends RecyclerView.ViewHolder{

        CircleImageView civ;   //내가만든 참조변수
        TextView tvFoodTitle;
        TextView tvFoodSub;

        public VH(@NonNull final View itemView) {
            super(itemView);

            this.civ= itemView.findViewById(R.id.civ);
            this.tvFoodTitle= itemView.findViewById(R.id.tv_food_title);
            this.tvFoodSub= itemView.findViewById(R.id.tv_food_sub);



//food category page 각 recyclerview 에 리스너 달아주기 -> 누르면 카테고리1 페이지로 이동
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, ""+tvFoodSub.getText(), Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(context, VeganActivity.class);
                    intent.putExtra("civ", items.get(getLayoutPosition()).civ);
                    intent.putExtra("food_bg", items.get(getLayoutPosition()).food_bg);
                    intent.putExtra("foodTitle", items.get(getLayoutPosition()).foodTitle);
                    intent.putExtra("foodSub", items.get(getLayoutPosition()).foodSub);
                    intent.putExtra("foodMsg", items.get(getLayoutPosition()).foodMsg);

                    context.startActivity(intent);
                }
            });
        }
    }

}
