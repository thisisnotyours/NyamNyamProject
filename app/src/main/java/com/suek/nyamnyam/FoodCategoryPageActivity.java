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
        items.add(new CategoryPageItems(R.drawable.bibimbap, "VEGAN", "채식주의"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "SOUP", "국/ 찌개"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "RICE", "밥"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "MEAT", "고기"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "NOODLE", "면"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "PORRIDGE", "죽"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "BUNSIK", "분식"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "SNACK", "간식"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "PANCAKE", "전"));
        items.add(new CategoryPageItems(R.drawable.bibimbap, "SPECIAL", "명절음식"));

        recyclerView= findViewById(R.id.recycler);
        adapter= new CategoryPageAdapter(this, items);
        recyclerView.setAdapter(adapter);








    }




}
