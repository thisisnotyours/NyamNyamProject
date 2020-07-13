package com.suek.nyamnyam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentTab4Coupon extends Fragment {

    ArrayList<CouponItem> couponItems= new ArrayList<>();
    CouponAdapter adapter;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.tab4_coupon_fragment, container, false);


        couponItems.add(new CouponItem("https://freepngimg.com/thumb/web_design/51726-5-coupon-picture-free-hq-image.png","G market 50% discount", "2020-10-20"));
        couponItems.add(new CouponItem("https://freepngimg.com/thumb/web_design/51726-5-coupon-picture-free-hq-image.png","G market 50% discount", "2020-10-20"));
        couponItems.add(new CouponItem("https://freepngimg.com/thumb/web_design/51726-5-coupon-picture-free-hq-image.png","G market 50% discount", "2020-10-20"));
        couponItems.add(new CouponItem("https://freepngimg.com/thumb/web_design/51726-5-coupon-picture-free-hq-image.png","G market 50% discount", "2020-10-20"));
        couponItems.add(new CouponItem("https://freepngimg.com/thumb/web_design/51726-5-coupon-picture-free-hq-image.png","G market 50% discount", "2020-10-20"));
        couponItems.add(new CouponItem("https://freepngimg.com/thumb/web_design/51726-5-coupon-picture-free-hq-image.png","G market 50% discount", "2020-10-20"));
        couponItems.add(new CouponItem("https://freepngimg.com/thumb/web_design/51726-5-coupon-picture-free-hq-image.png","G market 50% discount", "2020-10-20"));
        couponItems.add(new CouponItem("https://freepngimg.com/thumb/web_design/51726-5-coupon-picture-free-hq-image.png","G market 50% discount", "2020-10-20"));
        couponItems.add(new CouponItem("https://freepngimg.com/thumb/web_design/51726-5-coupon-picture-free-hq-image.png","G market 50% discount", "2020-10-20"));
        couponItems.add(new CouponItem("https://freepngimg.com/thumb/web_design/51726-5-coupon-picture-free-hq-image.png","G market 50% discount", "2020-10-20"));


        recyclerView= view.findViewById(R.id.recycler);
        adapter= new CouponAdapter(view.getContext(), couponItems);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
