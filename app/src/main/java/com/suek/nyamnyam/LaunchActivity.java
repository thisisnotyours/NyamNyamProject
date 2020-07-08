package com.suek.nyamnyam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        handler.sendEmptyMessageDelayed(0, 4000);

    }//onCreate..

    Handler handler= new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            Intent intent= new Intent(LaunchActivity.this, LoginActivity.class);
            startActivity(intent);

            finish();
        }
    };



}//Launch Activity..
