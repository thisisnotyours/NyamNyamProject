package com.suek.nyamnyam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MyPostActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<MyPostItem> myPostItems= new ArrayList<>();
    MyPostAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_post);

        recyclerView= findViewById(R.id.recycler);
        adapter= new MyPostAdapter(this, myPostItems);
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout= findViewById(R.id.refreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }














    public void clickBack(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
