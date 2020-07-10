package com.suek.nyamnyam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class RecipeActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager pager;
    TabRecipeAdapter recipeAdapter;

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

    }
}
