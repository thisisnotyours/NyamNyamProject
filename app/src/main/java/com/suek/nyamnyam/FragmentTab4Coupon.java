package com.suek.nyamnyam;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FragmentTab4Coupon extends Fragment {

    ArrayList<CouponItem> couponItems= new ArrayList<>();
    CouponAdapter adapter;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.tab4_coupon_fragment, container, false);


        couponItems.add(new CouponItem("https://pngimg.com/uploads/barcode/barcode_PNG74.png","G market 50% discount", "2020-10-20"));
        couponItems.add(new CouponItem("https://pngimg.com/uploads/barcode/barcode_PNG74.png","G market 50% discount", "2020-10-20"));
        couponItems.add(new CouponItem("https://pngimg.com/uploads/barcode/barcode_PNG74.png","G market 50% discount", "2020-10-20"));
        couponItems.add(new CouponItem("https://pngimg.com/uploads/barcode/barcode_PNG74.png","G market 50% discount", "2020-10-20"));
        couponItems.add(new CouponItem("https://pngimg.com/uploads/barcode/barcode_PNG74.png","G market 50% discount", "2020-10-20"));
        couponItems.add(new CouponItem("https://pngimg.com/uploads/barcode/barcode_PNG74.png","G market 50% discount", "2020-10-20"));



        recyclerView= view.findViewById(R.id.recycler);
        adapter= new CouponAdapter(view.getContext(), couponItems);
        recyclerView.setAdapter(adapter);


       /* recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(getContext());
                View view1= LayoutInflater.from(getContext()).inflate(R.layout.coupon_dialog, null);

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
        });*/


        return view;
    }
}
