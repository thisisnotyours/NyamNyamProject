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

    String civFood;
    String foodTitle;
    String foodCategory;
    String foodSub;

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



        Intent intent= getIntent();
        civFood= intent.getStringExtra("civFood");
        foodTitle= intent.getStringExtra("tvTitle");
        foodCategory= intent.getStringExtra("tvCategory");
        foodSub= intent.getStringExtra("tvSub");

        //Toast.makeText(this, ""+foodCategory, Toast.LENGTH_SHORT).show();

    }
}
