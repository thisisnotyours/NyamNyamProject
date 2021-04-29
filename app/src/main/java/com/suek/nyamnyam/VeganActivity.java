package com.suek.nyamnyam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class VeganActivity extends AppCompatActivity {

    //서버에 저장되어있느 모든 데이터
    ArrayList<VeganItem> allItems= new ArrayList<>();   //VeganItem 공유

    //recyclerview 의 데이터
    ArrayList<VeganItem> veganItems= new ArrayList<>();
    VeganAdapter veganAdapter;
    RecyclerView recyclerView;

    //받아올 카테고리 데이터
    TextView tv_title;
    TextView tv_sub;
    TextView tv_msg;
    LinearLayout linearLayout;

    // Text to speech
    TextToSpeech textToSpeech;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegan);

        //CategoryAdapter 에서 보낸  데이터 가져오기/받아오기를 (VeganActivity 로)    ---> 데이터들은 FoodCategoryPageActivity.java 에 입력/저장(ex; items.add(new Item...)
        Intent intent= getIntent();
        //int foodBackground= intent.getIntExtra("food_bg", R.drawable.ic_hot);   //R.drawable.ic_hot = 여기에는 해당 이미지가 없을때 대체로 보여주는 이미지.
        String foodBackground= intent.getStringExtra("foodBackground");
        String categoryTitle= intent.getStringExtra("foodTitle");   //name 틀리지 않게 입력!!!!!!  - CategoryPageItems 와 같은이름
        String categorySub= intent.getStringExtra("foodSub");
        String categoryMsg= intent.getStringExtra("foodMsg");


        //서버에서 데이터들 가져오는 메소드
        loadDataFromServer( categoryTitle );  //위의 String categoryTitle 이 지역변수여서(전역으로 만들어줄 수도 잇지만) 파라미터로 전달

        linearLayout= findViewById(R.id.linear_foodBackground);
        tv_title= findViewById(R.id.tv_title);
        tv_sub= findViewById(R.id.tv_sub);
        tv_msg= findViewById(R.id.tv_msg);

        //배경화면(LinearLayout)에 인터넷으로 포토Url 가져오기
        Glide.with(this).load(foodBackground).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    linearLayout.setBackground(resource);
                }
            }
        });
        tv_title.setText(categoryTitle);
        tv_sub.setText(categorySub);
        tv_msg.setText(categoryMsg);

        recyclerView= findViewById(R.id.recycler);
        veganAdapter= new VeganAdapter(this, veganItems);
        recyclerView.setAdapter(veganAdapter);






        //  Text to Speech
        textToSpeech= new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == textToSpeech.SUCCESS){
                    textToSpeech.setLanguage(Locale.KOREAN);
                }
            }
        });

        iv= findViewById(R.id.iv_speech);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.setPitch(1.0f);   //음성톤- 기본설정
                textToSpeech.setSpeechRate(0.5f); //읽는 속도 0.5배 빠르기
                textToSpeech.speak(tv_sub.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }//onCreate






    void loadDataFromServer( String categoryTitle ){
        Retrofit retrofit= RetrofitHelper_HowtoCook.getInstance();
        RetrofitService_HowtoCook retrofitService= retrofit.create(RetrofitService_HowtoCook.class);
        Call<ArrayList<VeganItem>> call= retrofitService.loadDataFromHowToCook();
        call.enqueue(new Callback<ArrayList<VeganItem>>() {
            @Override
            public void onResponse(Call<ArrayList<VeganItem>> call, Response<ArrayList<VeganItem>> response) {

                allItems= response.body();

                //Toast.makeText(VeganActivity.this, allItems.size()+"", Toast.LENGTH_SHORT).show();  //아이템에 몇개의 데이턱가 있는지 확인?

                for (VeganItem item : allItems){
                    if(item.cat.equalsIgnoreCase(categoryTitle)){
                        veganItems.add(item);
                        veganAdapter.notifyItemChanged(allItems.size()-1);
                    }else {

                    }
                }

            }

            @Override
            public void onFailure(Call<ArrayList<VeganItem>> call, Throwable t) {   //실패했을때 돌아오는 t
                Toast.makeText(VeganActivity.this, "Can't load! :("+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }//loadDataFromServer




}//Vegan Activity
