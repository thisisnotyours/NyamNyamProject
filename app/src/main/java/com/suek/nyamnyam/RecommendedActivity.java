package com.suek.nyamnyam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Locale;

public class RecommendedActivity extends AppCompatActivity {

    //받아올 추천레시피 데이터 목록
    ImageView iv;
    TextView tvTitle;
    TextView tvTitleEng;
    TextView tvSub;
    TextView tvMsg;
    TextView tvIng;
    TextView tvStep;
    TextView tvSource;

    ImageView ivHeadset;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended);

        Intent intent= getIntent();
        String foodIv= intent.getStringExtra("foodIv");
        String foodTitle= intent.getStringExtra("foodTitle");
        String foodTitleEng= intent.getStringExtra("foodTitleEng");
        String foodSub= intent.getStringExtra("foodSub");
        //String foodMsg= intent.getStringExtra("foodMsg");
        String foodIng= intent.getStringExtra("foodIng");
        String foodStep= intent.getStringExtra("foodStep");
        String source= intent.getStringExtra("source");

        iv= findViewById(R.id.iv);
        tvTitle= findViewById(R.id.tv_title);
        tvTitleEng= findViewById(R.id.tv_title_eng);
        tvSub= findViewById(R.id.tv_sub);
        //tvMsg= findViewById(R.id.tv_msg);
        tvIng= findViewById(R.id.tv_ing);
        tvStep= findViewById(R.id.tv_step);
        tvSource= findViewById(R.id.tv_source);

        Glide.with(this).load(foodIv).into(iv);
        tvTitle.setText(foodTitle);
        tvTitleEng.setText(foodTitleEng);
        tvSub.setText(foodSub);
       // tvMsg.setText(foodMsg);
        tvIng.setText(foodIng);
        tvStep.setText(foodStep);
        tvSource.setText(source);


        tts= new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == tts.SUCCESS){
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });

        ivHeadset= findViewById(R.id.iv_headset);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.setPitch(1.0f);
                tts.setSpeechRate(0.5f);
                tts.speak(tvSub.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }//onCreate
}
