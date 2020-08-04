package com.suek.nyamnyam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Grid_myPostActivity extends AppCompatActivity {

    ImageView ivList;

    RecyclerView recyclerView;
    Grid_mypost_Adapter adapter;
    ArrayList<Grid_mypost_Item> items= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_my_post);

        recyclerView= findViewById(R.id.recycler);
        adapter= new Grid_mypost_Adapter(this, items);
        recyclerView.setAdapter(adapter);

        Intent intent= getIntent();
        String file= intent.getStringExtra("file");
        String date= intent.getStringExtra("date");
        String title= intent.getStringExtra("title");

        items.add(new Grid_mypost_Item("2020-07-28","https://recipe1.ezmember.co.kr/cache/recipe/2015/06/17/960fec592d6306a1ca52a72ec342c8a9.jpg","Gamjatang"));
        items.add(new Grid_mypost_Item("2020-07-28","https://recipe1.ezmember.co.kr/cache/recipe/2015/06/17/960fec592d6306a1ca52a72ec342c8a9.jpg","Gamjatang"));
        items.add(new Grid_mypost_Item("2020-07-28","https://recipe1.ezmember.co.kr/cache/recipe/2015/06/17/960fec592d6306a1ca52a72ec342c8a9.jpg","Gamjatang"));
        items.add(new Grid_mypost_Item("2020-07-28","https://recipe1.ezmember.co.kr/cache/recipe/2015/06/17/960fec592d6306a1ca52a72ec342c8a9.jpg","Gamjatang"));
        items.add(new Grid_mypost_Item("2020-07-28","https://recipe1.ezmember.co.kr/cache/recipe/2015/06/17/960fec592d6306a1ca52a72ec342c8a9.jpg","Gamjatang"));
        items.add(new Grid_mypost_Item("2020-07-28","https://recipe1.ezmember.co.kr/cache/recipe/2015/06/17/960fec592d6306a1ca52a72ec342c8a9.jpg","Gamjatang"));

        ivList= findViewById(R.id.iv_list);
        ivList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(getBaseContext(), MyPostActivity.class);
                startActivity(intent1);
            }
        });
    }
}
