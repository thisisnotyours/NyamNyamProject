package com.suek.nyamnyam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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


    // Expandable FAB 불린 참조변수
    Boolean isOpen= false;
    FloatingActionButton fab, fab1_my_blog, fab2_board, fab3_post;
    TextView tv_my_blog, tv_board, tv_post;
    Animation fab_open, fab_close, fab_clock, fab_anticlock;

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





        // Expandable FAB
        fab= findViewById(R.id.fab);
        fab1_my_blog= findViewById(R.id.fab1_my_blog);
        fab2_board= findViewById(R.id.fab2_board);
        fab3_post= findViewById(R.id.fab3_post);
        fab_open= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fab_clock= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_clock);
        fab_anticlock= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_anticlock);

        tv_my_blog= findViewById(R.id.tv_my_blog);
        tv_board= findViewById(R.id.tv_board);
        tv_post= findViewById(R.id.tv_post);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isOpen){                                 //isOpen 이 true? 아닐경우 else(위에서 이미 참조불린변수에 isOpen false 라고 줌)
                    tv_my_blog.setVisibility(View.VISIBLE);
                    tv_post.setVisibility(View.VISIBLE);
                    fab3_post.startAnimation(fab_open);
                    fab1_my_blog.startAnimation(fab_open);
                    fab.startAnimation(fab_anticlock);
                    isOpen= true;   //다음에 바뀔것을 생각해서
                }else {
                    tv_my_blog.setVisibility(View.INVISIBLE);
                    tv_post.setVisibility(View.INVISIBLE);
                    fab3_post.startAnimation(fab_close);
                    fab1_my_blog.startAnimation(fab_close);
                    fab.startAnimation(fab_clock);
                    isOpen= false;
                }
            }
        });


        fab3_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Share your cook :)", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(BoardActivity.this, EditPostActivity.class);
                startActivity(intent);
            }
        });


        fab1_my_blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "See what you've posted!", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(BoardActivity.this, MyPostActivity.class);
                startActivity(intent);
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
