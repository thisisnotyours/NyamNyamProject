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

        items.add(new TrendItem("https://pm1.narvii.com/7298/2899487a8271cf0687a12c56e200d8693a15deb7r1-1199-799v2_uhq.jpg", "Trending new here...."));
        items.add(new TrendItem("https://pm1.narvii.com/7298/2899487a8271cf0687a12c56e200d8693a15deb7r1-1199-799v2_uhq.jpg", "second...."));
        items.add(new TrendItem("https://pm1.narvii.com/7298/2899487a8271cf0687a12c56e200d8693a15deb7r1-1199-799v2_uhq.jpg", "third...."));
        items.add(new TrendItem("https://pm1.narvii.com/7298/2899487a8271cf0687a12c56e200d8693a15deb7r1-1199-799v2_uhq.jpg", "forth...."));
        items.add(new TrendItem("https://pm1.narvii.com/7298/2899487a8271cf0687a12c56e200d8693a15deb7r1-1199-799v2_uhq.jpg", "fifth...."));


        recyclerView= view.findViewById(R.id.recycler);
        trendAdapter= new TrendAdapter(view.getContext(), items);
        recyclerView.setAdapter(trendAdapter);

        return view;

    }
}
