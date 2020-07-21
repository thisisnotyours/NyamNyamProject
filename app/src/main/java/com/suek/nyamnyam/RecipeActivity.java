package com.suek.nyamnyam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

public class RecipeActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager pager;
    TabRecipeAdapter recipeAdapter;

    //Vegan 에서 받아온 데이터 참조변수로 만들기 --> 이 데이터를 보여주는 뷰는 HowtoCook 뷰임
    String civFood;   //veganItem
    String foodTitle;
    String foodCategory;
    String foodSub;

    String foodIng;
    String foodStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        tabLayout= findViewById(R.id.tab_layout);
        pager= findViewById(R.id.pager);

        recipeAdapter= new TabRecipeAdapter(getSupportFragmentManager());
        pager.setAdapter(recipeAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        //비건 Adapter 에서 받아온 데이터 위에서 String 으로 받기?
        Intent intent= getIntent();
        civFood= intent.getStringExtra("civFood");
        foodTitle= intent.getStringExtra("tvTitle");
        foodCategory= intent.getStringExtra("tvCategory");
        foodSub= intent.getStringExtra("tvSub");

        foodIng=intent.getStringExtra("tvIng");
        foodStep= intent.getStringExtra("tvStep");

        //Toast.makeText(this, ""+foodCategory, Toast.LENGTH_SHORT).show();

    }
}
