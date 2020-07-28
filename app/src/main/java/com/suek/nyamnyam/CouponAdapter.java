package com.suek.nyamnyam;

import android.app.AlertDialog;
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
                    AlertDialog.Builder builder= new AlertDialog.Builder(context);
                    View view1= LayoutInflater.from(context).inflate(R.layout.coupon_dialog, null);

                    CouponItem item= couponItems.get(0);
                    TextView tvTitle= view1.findViewById(R.id.tv_title);
                    TextView tvDate= view1.findViewById(R.id.tv_date);
                    ImageView iv= view1.findViewById(R.id.iv_barcode);

                    tvTitle.setText(item.tvTitle);
                    tvDate.setText(item.tvDate);
                    Glide.with(view1).load(item.imgUrl).into(iv);

                    builder.setView(view1);
                    AlertDialog alertDialog= builder.create();
                    alertDialog.show();
                }
            });
        }
    }
}
