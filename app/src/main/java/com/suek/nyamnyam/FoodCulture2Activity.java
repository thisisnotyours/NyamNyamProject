package com.suek.nyamnyam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FoodCulture2Activity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvSub;
    ImageView ivFile;
    TextView tvSource;
    TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_culture2);

        //Food culture1 에서 보낸 데이터 받기 (file, title, msg)
        Intent intent= getIntent();
        String title= intent.getStringExtra("title");
        String sub= intent.getStringExtra("sub");
        String file= intent.getStringExtra("file");
        String source= intent.getStringExtra("source");
        String msg= intent.getStringExtra("msg");

        tvTitle= findViewById(R.id.tv_title);
        tvSub= findViewById(R.id.tv_sub);
        ivFile= findViewById(R.id.iv);
        tvSource= findViewById(R.id.tv_source);
        tvMsg= findViewById(R.id.tv_msg);

        tvTitle.setText(title);
        Glide.with(this).load(file).into(ivFile);
        tvSub.setText(sub);
        tvSource.setText(source);
        tvMsg.setText(msg);




    }//onCreate




}//FoodCulture2Activity
