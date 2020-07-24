package com.suek.nyamnyam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager pager;
    TabAdapter tabAdapter;

    // Expandable FAB 불린 참조변수
    Boolean isOpen= false;
    FloatingActionButton fab, fab1_my_blog, fab2_board, fab3_post;
    TextView tv_my_blog, tv_board, tv_post;
    Animation fab_open, fab_close, fab_clock, fab_anticlock;

    // 로그인 정보 불러들이는 참조변수
    TextView headerEmail, headerNickname;
    CircleImageView headerProfile;



    // Draggable FAB
    float startX;
    float startRawX;
    float distanceX;
    int lastAction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       //getSupportActionBar().setLogo(R.drawable.gametitle_09);


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






        navigationView= findViewById(R.id.nav);
        // 불러올 로그인정보에 쓸 데이터를 넣어줄 아이디 찾아주기
        headerEmail= navigationView.getHeaderView(0).findViewById(R.id.tv_email);
        headerNickname= navigationView.getHeaderView(0).findViewById(R.id.tv_name);
        headerProfile= navigationView.getHeaderView(0).findViewById(R.id.civ_profile);

        // 로그인정보 불러들여오기
        SharedPreferences pref= getSharedPreferences("Data", MODE_PRIVATE);
        String nickName= pref.getString("nickName", "");
        String email= pref.getString("email", "");
        String profileUrl= pref.getString("profileUrl", "");
        headerNickname.setText(nickName);
        headerEmail.setText(email);
        Glide.with(this).load(profileUrl).into(headerProfile);

        // 네비게이션 아이템 리스너
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




        // Expandable FAB
        fab= findViewById(R.id.fab);
        fab1_my_blog= findViewById(R.id.fab1_my_blog);
        fab2_board= findViewById(R.id.fab2_board);
        fab3_post= findViewById(R.id.fab3_post);
        fab_open= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fab_clock= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_clock);
        fab_anticlock= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_anticlock);

        tv_my_blog= findViewById(R.id.tv_my_blog);
        tv_board= findViewById(R.id.tv_board);
        tv_post= findViewById(R.id.tv_post);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){                                 //isOpen 이 true? 아닐경우 else(위에서 이미 참조불린변수에 isOpen false 라고 줌)
                    tv_my_blog.setVisibility(View.VISIBLE);
                    tv_board.setVisibility(View.VISIBLE);
                    tv_post.setVisibility(View.VISIBLE);
                    fab3_post.startAnimation(fab_close);
                    fab2_board.startAnimation(fab_close);
                    fab1_my_blog.startAnimation(fab_close);
                    fab.startAnimation(fab_anticlock);
                    isOpen= false;   //다음에 바뀔것을 생각해서
                }else {
                    tv_my_blog.setVisibility(View.INVISIBLE);
                    tv_board.setVisibility(View.INVISIBLE);
                    tv_post.setVisibility(View.INVISIBLE);
                    fab3_post.startAnimation(fab_open);
                    fab2_board.startAnimation(fab_open);
                    fab1_my_blog.startAnimation(fab_open);
                    fab.startAnimation(fab_clock);
                    isOpen= true;
                }
            }
        });


        fab3_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Share your cook :)", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(MainActivity.this, EditPostActivity.class);
                startActivity(intent);
            }
        });

        fab2_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Wanna check what others shared?", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(MainActivity.this, BoardActivity.class);
                startActivity(intent);
            }
        });

        fab1_my_blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "See what you've posted!", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(MainActivity.this, MyPostActivity.class);
                startActivity(intent);
            }
        });





        //Draggable FAB...
        /*fab.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {    //view v 는 FAB 를 누른놈
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN:
                        startX= v.getX() - event.getRawX();
                        startRawX= event.getRawX();
                        lastAction= MotionEvent.ACTION_DOWN;
                        break;
                        
                    case MotionEvent.ACTION_MOVE:
                        v.setX(event.getRawX() + startX);
                        v.setY(event.getRawY() + startX);
                        lastAction= MotionEvent.ACTION_MOVE;
                        break;
                        
                    case MotionEvent.ACTION_UP:
                        distanceX= event.getRawX()-startRawX;
                        if(Math.abs(distanceX)<10){

                        }break;

                    default:
                        return false;
                }
                
                return false;
            }
        });*/


    }//onCreate..

}//MainActivity..
