package com.suek.nyamnyam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class VeganActivity extends AppCompatActivity {

    //recyclerview 의 데이터
    ArrayList<VeganItem> veganItems= new ArrayList<>();
    VeganAdapter veganAdapter;
    RecyclerView recyclerView;

    //받아올 카테고리 데이터
    TextView tv_title;
    TextView tv_sub;
    TextView tv_msg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegan);

        //카테고리 데이터 가져오기  ---> 데이터들은 FragmentTab1Food.java 에 입력/저장
        Intent intent= getIntent();
        int civ= intent.getIntExtra("civ", R.drawable.ic_hot);   //R.drawable.ic_hot = 여기에는 해당 이미지가 없을때 대체로 보여주는 이미지.
        String categoryTitle= intent.getStringExtra("foodTitle");   //name 틀리지 않게 입력!!!!!!
        String categorySub= intent.getStringExtra("foodSub");

        tv_title= findViewById(R.id.tv_title);
        tv_sub= findViewById(R.id.tv_sub);
        tv_msg= findViewById(R.id.tv_msg);

        tv_title.setText(categoryTitle);
        tv_sub.setText(categorySub);





        //recyclerview items
        veganItems.add(new VeganItem(R.drawable.bibimbap, "Sanchae Bibmbap", "VEGAN/ NON HALAL", "산채 비빔밥"));
        veganItems.add(new VeganItem(R.drawable.bibimbap, "Sanchae Bibmbap", "VEGAN/ NON HALAL", "산채 비빔밥"));
        veganItems.add(new VeganItem(R.drawable.bibimbap, "Sanchae Bibmbap", "VEGAN/ NON HALAL", "산채 비빔밥"));
        veganItems.add(new VeganItem(R.drawable.bibimbap, "Sanchae Bibmbap", "VEGAN/ NON HALAL", "산채 비빔밥"));

        recyclerView= findViewById(R.id.recycler);
        veganAdapter= new VeganAdapter(this, veganItems);
        recyclerView.setAdapter(veganAdapter);

    }
}
