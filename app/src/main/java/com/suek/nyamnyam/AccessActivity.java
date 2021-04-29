package com.suek.nyamnyam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class AccessActivity extends AppCompatActivity {

    private TextView tvEmail;
    private EditText etNickname;
    private CircleImageView civProfile;
    private CheckBox checkBox;
    private Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);

        //이 Access 화면에서 2초 뒤에 Main 화면으로 넘어가기
        //handler.sendEmptyMessageDelayed(0, 2000);

        Intent intent= getIntent();
        String nickName= intent.getStringExtra("nickName");    //받아온 닉네임값
        String email= intent.getStringExtra("email");          //받아온 닉네임값
        String profileUrl= intent.getStringExtra("profileUrl");  //받아온 프로필 이미지값


        Log.i("nickName", nickName+"");
        Log.i("photoUrl", profileUrl+"");

        tvEmail= findViewById(R.id.tv_user_email);
        tvEmail.setText(email);

        etNickname= findViewById(R.id.et_nickname);
        etNickname.setText(nickName);    //1. 닉네임- 텍스트뷰에 세팅

        civProfile= findViewById(R.id.civ_profile);
        Glide.with(this).load(profileUrl).into(civProfile);   //2. 포토Url- Civ 뷰에 세팅




        checkBox= findViewById(R.id.checkbox);

        loginBtn= findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    SharedPreferences pref= getSharedPreferences("Data", MODE_PRIVATE);  //문서에 데이터를 저장해주는 객체 소환
                    SharedPreferences.Editor editor= pref.edit();    //문서저장 시작..
                    editor.putString("nickName", nickName);
                    editor.putString("email",email);
                    editor.putString("profileUrl", profileUrl);
                    editor.commit();     //작업완료

                    Intent intent1= new Intent(AccessActivity.this, MainActivity.class);
                    startActivity(intent1);
                    finish();

                }else {
                    Intent intent1= new Intent(AccessActivity.this, MainActivity.class);
                    startActivity(intent1);
                    finish();
                }
            }
        });











    }//onCreate..








    /*Handler handler= new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            Intent intent= new Intent(AccessActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };*/



    /*public void clickTermsCondition(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        View view= LayoutInflater.from(this).inflate(R.layout.terms_condition, null);
        builder.setView(view);
        AlertDialog alertDialog= builder.create();
        alertDialog.show();
    }*/


}//Access Activity..
