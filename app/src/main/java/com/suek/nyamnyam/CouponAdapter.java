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

public class CouponAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<CouponItem> couponItems;

    public CouponAdapter(Context context, ArrayList<CouponItem> couponItems) {
        this.context = context;
        this.couponItems = couponItems;
    }




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View itemView= layoutInflater.inflate(R.layout.recycler_coupon, parent, false);
        VH holder= new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;
        CouponItem couponItem= couponItems.get(position);
        Glide.with(context).load(couponItem.imgUrl).into(vh.imgUrl);
        vh.tvCouponTitle.setText(couponItem.tvTitle);
        vh.tvCouponDate.setText(couponItem.tvDate);
    }

    @Override
    public int getItemCount() {
        return couponItems.size();
    }



    class VH extends RecyclerView.ViewHolder{

        ImageView imgUrl;
        TextView tvCouponTitle;
        TextView tvCouponDate;

        public VH(@NonNull final View itemView) {
            super(itemView);
            this.imgUrl= itemView.findViewById(R.id.iv_coupon);
            this.tvCouponTitle= itemView.findViewById(R.id.tv_coupon_title);
            this.tvCouponDate= itemView.findViewById(R.id.tv_coupon_date);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, ""+getLayoutPosition(), Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(context, CouponActivity.class);
                    intent.putExtra("image", couponItems.get(getLayoutPosition()).imgUrl);
                    intent.putExtra("title", couponItems.get(getLayoutPosition()).tvTitle);
                    context.startActivity(intent);
                }
            });
        }
    }
}
