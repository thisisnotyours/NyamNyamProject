package com.suek.nyamnyam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager pager;
    TabAdapter tabAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.gametitle_09);



        tabLayout= findViewById(R.id.tab_layout);
        tabAdapter= new TabAdapter(getSupportFragmentManager());
        pager= findViewById(R.id.pager);
        pager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(pager);

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


        drawerLayout= findViewById(R.id.drawer_layout);
        navigationView= findViewById(R.id.nav);
        actionBarDrawerToggle= new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name );
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();





        // 네비게이션 아이템 리스너
        navigationView= findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.home:
                        Intent intent= new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;

                    /*case R.id.account:
                        Intent intent1= new Intent(MainActivity.this, AccountActivity.class);
                        startActivity(intent1);
                        break;*/

                    case R.id.food_category:
                        Intent intent2= new Intent(MainActivity.this, FoodCategoryPageActivity.class);
                        startActivity(intent2);
                        break;

                    /*case R.id.saved:
                        Intent intent3= new Intent(MainActivity.this, SavedActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.setting:
                        Intent intent4= new Intent(MainActivity.this, SettingActivity.class);
                        startActivity(intent4);
                        break;*/

                }

                return true;
            }
        });


    }//onCreate..
}//MainActivity..
