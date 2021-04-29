package com.suek.nyamnyam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FoodCulture2Activity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvSub;
    ImageView iv_headset;
    ImageView ivFile;
    TextView tvSource;
    TextView tvMsg;

    TextToSpeech tts;

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
        String imgUrl= "http://suhyun2963.dothome.co.kr/FoodCulture/"+file;
        Log.i("img",imgUrl);   //업로드한 이미지가 있는지 로그로 확인
        Glide.with(this).load(imgUrl).into(ivFile);
        tvSub.setText(sub);
        tvSource.setText(source);
        tvMsg.setText(msg);


        // Text to Speech
        tts= new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==tts.SUCCESS){
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });

        iv_headset= findViewById(R.id.iv_headset);
        iv_headset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.setPitch(1.0f);
                tts.setSpeechRate(0.5f);
                tts.speak(tvSub.getText().toString(), tts.QUEUE_FLUSH, null);
            }
        });


    }//onCreate




}//FoodCulture2Activity
