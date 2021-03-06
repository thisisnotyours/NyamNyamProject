package com.suek.nyamnyam;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
        String imgUrl= "http://suhyun2963.dothome.co.kr/HowToCook/"+veganItem.file;
        Log.i("img", imgUrl);
        Glide.with(context).load(imgUrl).into(vh.civ);
        vh.tvTitle.setText(veganItem.title);
        vh.tvCategory.setText(veganItem.cat);
        vh.tvSub.setText(veganItem.sub);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }




    class VH extends RecyclerView.ViewHolder{

        CircleImageView civ;
        TextView tvTitle;
        TextView tvCategory;
        TextView tvSub;
     /*참조변수 이름바꾸기... 헷갈림*/

        public VH(@NonNull final View itemView) {
            super(itemView);

            this.civ= itemView.findViewById(R.id.civ);
            this.tvTitle= itemView.findViewById(R.id.tv_title);
            this.tvCategory= itemView.findViewById(R.id.tv_category);
            this.tvSub= itemView.findViewById(R.id.tv_sub);




            //클릭리스너- Recipe Activity 로 이동
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, ""+tvTitle.getText(), Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(context, RecipeActivity.class);                              //recycler vegan 데이터 Recipe activity 로 보내기
                    intent.putExtra("civFood", items.get(getLayoutPosition()).file);
                    intent.putExtra("tvTitle", items.get(getLayoutPosition()).title);
                    intent.putExtra("tvCategory", items.get(getLayoutPosition()).cat);
                    intent.putExtra("tvSub", items.get(getLayoutPosition()).sub);

                    intent.putExtra("tvIng",items.get(getLayoutPosition()).ing);
                    intent.putExtra("tvStep", items.get(getLayoutPosition()).step);

                    context.startActivity(intent);
                }
            });


        }// VH- itemView
    }// VH- RecyclerView


    }

