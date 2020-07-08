package com.suek.nyamnyam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class AccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);

        //handler.sendEmptyMessageDelayed(0, 3000);

    }//onCreate..

    /*Handler handler= new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            Intent intent= new Intent(AccessActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };*/

}//Access Activity..
