package com.suek.nyamnyam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class AccessActivity extends AppCompatActivity {

    private TextView tvNickname;  //받아온 닉네임값
    private CircleImageView civ;   //받아온 프로필 이미지값

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);

        handler.sendEmptyMessageDelayed(0, 2000);

        Intent intent= getIntent();
        String nickName= intent.getStringExtra("nickName");
        String profileUrl= intent.getStringExtra("profileUrl");

        tvNickname= findViewById(R.id.tv_nickname);
        tvNickname.setText(nickName);    //닉네임- 텍스트뷰에 세팅

        civ= findViewById(R.id.civ);
        Glide.with(this).load(profileUrl).into(civ);   //포토Url- Civ 뷰에 세팅



    }//onCreate..

    Handler handler= new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            Intent intent= new Intent(AccessActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };

}//Access Activity..
