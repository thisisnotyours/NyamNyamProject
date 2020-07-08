package com.suek.nyamnyam;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentTab1Food extends Fragment {

    ArrayList<Item> items= new ArrayList<>();
    CategoryAdapter adapter;
    RecyclerView recyclerView;

    ArrayList<RecommendedItems> recommendedItems= new ArrayList<>();
    RecommendedAdapter recommendedAdapter;
    RecyclerView recommendedRecyclerView;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.tab1_food_fragment, container, false);

        items.add(new Item(R.drawable.gametitle_09, "VEGAN"));
        items.add(new Item(R.drawable.gametitle_09, "SOUP"));
        items.add(new Item(R.drawable.gametitle_09, "RICE"));
        items.add(new Item(R.drawable.gametitle_09, "MEAT"));
        items.add(new Item(R.drawable.gametitle_09, "VEGAN"));
        items.add(new Item(R.drawable.gametitle_09, "SOUP"));
        items.add(new Item(R.drawable.gametitle_09, "RICE"));
        items.add(new Item(R.drawable.gametitle_09, "MEAT"));
        items.add(new Item(R.drawable.gametitle_09, "VEGAN"));
        items.add(new Item(R.drawable.gametitle_09, "SOUP"));
        items.add(new Item(R.drawable.gametitle_09, "RICE"));
        items.add(new Item(R.drawable.gametitle_09, "MEAT"));


        recyclerView= view.findViewById(R.id.recycler_food_category);
        adapter= new CategoryAdapter(view.getContext(), items);
        recyclerView.setAdapter(adapter);


        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));

        recommendedRecyclerView= view.findViewById(R.id.recycler_recommended);
        recommendedAdapter= new RecommendedAdapter(getActivity(), recommendedItems);
        recommendedRecyclerView.setAdapter(recommendedAdapter);

        return view;
    }





}
