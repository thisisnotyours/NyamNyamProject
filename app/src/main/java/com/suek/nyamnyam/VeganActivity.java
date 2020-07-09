package com.suek.nyamnyam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class VeganActivity extends AppCompatActivity {

    ArrayList<VeganItem> veganItems= new ArrayList<>();
    VeganAdapter adapter;
    RecyclerView recyclerView;

    TextView tv_category_title;
    TextView tv_category_sub;
    TextView tv_msg;

    //이름 다시 세팅하기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegan);

        Intent intent= getIntent();
        int civ= intent.getIntExtra("civ", R.drawable.ic_hot);
        String categoryTitle= intent.getStringExtra("categoryTitle");
        String categorySub= intent.getStringExtra("categorySub");

        tv_category_title= findViewById(R.id.tv_category_title);
        tv_category_sub= findViewById(R.id.tv_category_sub);
        tv_msg= findViewById(R.id.tv_msg);

        tv_category_title.setText(categoryTitle);
        tv_category_sub.setText(categorySub);





        veganItems.add(new VeganItem(R.drawable.bibimbap, "Sanchae Bibmbap", "VEGAN/ NON HALAL", "산채 비빔밥"));
        veganItems.add(new VeganItem(R.drawable.bibimbap, "Sanchae Bibmbap", "VEGAN/ NON HALAL", "산채 비빔밥"));
        veganItems.add(new VeganItem(R.drawable.bibimbap, "Sanchae Bibmbap", "VEGAN/ NON HALAL", "산채 비빔밥"));
        veganItems.add(new VeganItem(R.drawable.bibimbap, "Sanchae Bibmbap", "VEGAN/ NON HALAL", "산채 비빔밥"));

        recyclerView= findViewById(R.id.recycler);
        adapter= new VeganAdapter(this, veganItems);
        recyclerView.setAdapter(adapter);

    }
}
