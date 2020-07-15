package com.suek.nyamnyam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

//게시판
public class BoardActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BoardAdapter adapter;
    ArrayList<BoardItem> boardItems= new ArrayList<>();
    SwipeRefreshLayout refreshLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        recyclerView= findViewById(R.id.recycler);
        adapter= new BoardAdapter(this, boardItems);
        recyclerView.setAdapter(adapter);

        refreshLayout= findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
                refreshLayout.setRefreshing(false);
            }
        });
    }//onCreate







    @Override
    protected void onResume(){
        super.onResume();

        loadData();
    }



    void loadData(){

        // 먼저 리사이클러가 게시판에 로드가 되는지 먼저 확인하기
        /*boardItems.add(new BoardItem(1, "dkfld", "dsfkjdf", null, "sdjf"));
        boardItems.add(new BoardItem(1, "dkfld", "dsfkjdf", null, "sdjf"));
        boardItems.add(new BoardItem(1, "dkfld", "dsfkjdf", null, "sdjf"));
        boardItems.add(new BoardItem(1, "dkfld", "dsfkjdf", null, "sdjf"));
        adapter.notifyDataSetChanged();*/



        Retrofit retrofit= RetrofitHelper.getInstance();
        RetrofitService retrofitService= retrofit.create(RetrofitService.class);
        Call<ArrayList<BoardItem>> call= retrofitService.loadDataFromBoard();
        call.enqueue(new Callback<ArrayList<BoardItem>>() {
            @Override
            public void onResponse(Call<ArrayList<BoardItem>> call, Response<ArrayList<BoardItem>> response) {
                if(response.isSuccessful()){
                    Toast.makeText(BoardActivity.this, "Loaded successful", Toast.LENGTH_SHORT).show();
                    ArrayList<BoardItem> items= response.body();

                    boardItems.clear();
                    adapter.notifyDataSetChanged();

                    for (BoardItem item : items){
                        boardItems.add(0,item);
                        adapter.notifyItemInserted(0);
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<BoardItem>> call, Throwable t) {
                Toast.makeText(BoardActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }







    public void clickEditPost(View view){
        Intent intent= new Intent(this, EditPostActivity.class );
        startActivity(intent);
    }


    public void clickBack(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
