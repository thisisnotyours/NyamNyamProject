package com.suek.nyamnyam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

public class VeganActivity extends AppCompatActivity {

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
    AppCompatImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegan);

        //CategoryAdapter 에서 보낸  데이터 가져오기/받아오기를 (VeganActivity 로)    ---> 데이터들은 FoodCategoryPageActivity.java 에 입력/저장(ex; items.add(new Item...)
        Intent intent= getIntent();
        int foodBackground= intent.getIntExtra("food_bg", R.drawable.ic_hot);   //R.drawable.ic_hot = 여기에는 해당 이미지가 없을때 대체로 보여주는 이미지.
        String categoryTitle= intent.getStringExtra("foodTitle");   //name 틀리지 않게 입력!!!!!!  - CategoryPageItems 와 같은이름
        String categorySub= intent.getStringExtra("foodSub");
        String categoryMsg= intent.getStringExtra("foodMsg");


        linearLayout= findViewById(R.id.linear_foodBackground);
        tv_title= findViewById(R.id.tv_title);
        tv_sub= findViewById(R.id.tv_sub);
        tv_msg= findViewById(R.id.tv_msg);


        linearLayout.setBackgroundResource(foodBackground);
        tv_title.setText(categoryTitle);
        tv_sub.setText(categorySub);
        tv_msg.setText(categoryMsg);




//recyclerview items
        if(categoryTitle.equals("VEGAN")){
            veganItems.add(new VeganItem("https://www.chungjungone.com/upload/knowhow/table/20170715_103952082_54152.jpg", "Sanchae Bibmbap", "VEGAN", "산채 비빔밥"));
            veganItems.add(new VeganItem("https://www.chungjungone.com/upload/knowhow/table/20170715_103952082_54152.jpg", "Sanchae Bibmbap", "VEGAN", "산채 비빔밥"));
            veganItems.add(new VeganItem("https://www.chungjungone.com/upload/knowhow/table/20170715_103952082_54152.jpg", "Sanchae Bibmbap", "VEGAN", "산채 비빔밥"));
            veganItems.add(new VeganItem("https://www.chungjungone.com/upload/knowhow/table/20170715_103952082_54152.jpg", "Sanchae Bibmbap", "VEGAN", "산채 비빔밥"));
        }else if(categoryTitle.equals("SOUP")){
            veganItems.add(new VeganItem("https://www.chungjungone.com/upload/knowhow/table/20170715_103952082_54152.jpg", "Sanchae Bibmbap", "SOUP", "산채 비빔밥"));
        }else if(categoryTitle.equals("RICE")){
            veganItems.add(new VeganItem("https://www.chungjungone.com/upload/knowhow/table/20170715_103952082_54152.jpg", "Sanchae Bibmbap", "RICE", "산채 비빔밥"));
        }else if(categoryTitle.equals("MEAT")){
            veganItems.add(new VeganItem("https://www.chungjungone.com/upload/knowhow/table/20170715_103952082_54152.jpg", "Sanchae Bibmbap", "MEAT", "산채 비빔밥"));
        }else if(categoryTitle.equals("NOODLE")){
            veganItems.add(new VeganItem("https://www.chungjungone.com/upload/knowhow/table/20170715_103952082_54152.jpg", "Sanchae Bibmbap", "NOODLE", "산채 비빔밥"));
        }else if(categoryTitle.equals("VEGETABLES")){
            veganItems.add(new VeganItem("https://www.chungjungone.com/upload/knowhow/table/20170715_103952082_54152.jpg", "Sanchae Bibmbap", "VEGETABLES", "산채 비빔밥"));
        }else if(categoryTitle.equals("DESSERT")){
            veganItems.add(new VeganItem("https://www.chungjungone.com/upload/knowhow/table/20170715_103952082_54152.jpg", "Sanchae Bibmbap", "DESSERT", "산채 비빔밥"));
        }else if(categoryTitle.equals("PORRIDGE")){

        }else if(categoryTitle.equals("SPECIAL")){

        }else if(categoryTitle.equals("PANCAKE")){

        }else if(categoryTitle.equals("STREET FOOD")){

        }

        recyclerView= findViewById(R.id.recycler);
        veganAdapter= new VeganAdapter(this, veganItems);
        recyclerView.setAdapter(veganAdapter);




        //  Text to Speech
        iv= findViewById(R.id.iv_speech);
        textToSpeech= new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result= textToSpeech.setLanguage(Locale.KOREA);
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Toast.makeText(VeganActivity.this, "No support from this language", Toast.LENGTH_SHORT).show();
                    }else {
                        iv.setEnabled(true);
                        textToSpeech.setPitch(0.7f);
                        textToSpeech.setSpeechRate(1.2f);
                    }
                }
            }
        });

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //textToSpeech.speak(tv_sub)
            }
        });

    }




}
