package com.suek.nyamnyam;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class FoodCategoryPageActivity extends AppCompatActivity {

    ArrayList<CategoryPageItems> items= new ArrayList<>();
    CategoryPageAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category_page);

        //Food Category Recyclerview items
        items.add(new CategoryPageItems(R.drawable.bibimbap, "SOUP", "Non-Halal"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "SOUP", "Non-Halal"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "SOUP", "Non-Halal"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "SOUP", "Non-Halal"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "SOUP", "Non-Halal"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "SOUP", "Non-Halal"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "SOUP", "Non-Halal"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "SOUP", "Non-Halal"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "SOUP", "Non-Halal"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "SOUP", "Non-Halal"));

        recyclerView= findViewById(R.id.recycler);
        adapter= new CategoryPageAdapter(this, items);
        recyclerView.setAdapter(adapter);








    }




}
