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

public class FragmentTab2Trend extends Fragment {

    ArrayList<TrendItem> items= new ArrayList<>();
    RecyclerView recyclerView;
    TrendAdapter trendAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.tab2_trend_fragment, container, false);

        items.add(new TrendItem("https://ca-times.brightspotcdn.com/dims4/default/d49ce7b/2147483647/strip/true/crop/1920x1080+0+0/resize/1486x836!/quality/90/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F50%2F76%2F025fca784c0888194d376917b799%2Fla-fo-dalgona-iced-coffee-south-korea-isolation.jpg", "Dalgona coffee"));
        items.add(new TrendItem("https://pm1.narvii.com/7298/2899487a8271cf0687a12c56e200d8693a15deb7r1-1199-799v2_uhq.jpg", "BTS"));
        items.add(new TrendItem("https://blog.snackfever.com/wp-content/uploads/2017/01/honeycheesefirebox_blogfeature.jpg", "Snack"));
        items.add(new TrendItem("https://www.koreaforniancooking.com/kcook/wp-content/uploads/2013/10/fried-chicken.jpg", "Korean Chicken"));
        items.add(new TrendItem("https://alittleyum.files.wordpress.com/2013/01/namufries.jpg", "Fusion"));



        recyclerView= view.findViewById(R.id.recycler);
        trendAdapter= new TrendAdapter(view.getContext(), items);
        recyclerView.setAdapter(trendAdapter);

        return view;

    }
}
