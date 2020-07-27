package com.suek.nyamnyam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyPostActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<BoardItem> boardItems= new ArrayList<>();
    MyPostAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_post);

        recyclerView= findViewById(R.id.recycler);
        adapter= new MyPostAdapter(this, boardItems);
        recyclerView.setAdapter(adapter);

        loadDataFromServer();

        swipeRefreshLayout= findViewById(R.id.refreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadDataFromServer();
            }
        });
    }



    public void loadDataFromServer(){
        SharedPreferences preferences= getSharedPreferences("Data", MODE_PRIVATE);
        String email= preferences.getString("email","");

        Retrofit retrofit= RetrofitHelper.getInstance();
        RetrofitService retrofitService= retrofit.create(RetrofitService.class);
        Call<ArrayList<BoardItem>> call= retrofitService.loadDataFromBoard_mine(email);
        call.enqueue(new Callback<ArrayList<BoardItem>>() {
            @Override
            public void onResponse(Call<ArrayList<BoardItem>> call, Response<ArrayList<BoardItem>> response) {
                if(response.isSuccessful()){
                    boardItems.clear();
                    adapter.notifyDataSetChanged();

                    ArrayList<BoardItem> items= response.body();
                    //Toast.makeText(MyPostActivity.this, "ssss"+items.size(), Toast.LENGTH_SHORT).show();
                    for( BoardItem item : items){
                        boardItems.add(0, item);
                        adapter.notifyItemInserted(0);
                    }
                }
            }
            @Override
            public void onFailure(Call<ArrayList<BoardItem>> call, Throwable t) {
                Toast.makeText(MyPostActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }













    public void clickBack(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
