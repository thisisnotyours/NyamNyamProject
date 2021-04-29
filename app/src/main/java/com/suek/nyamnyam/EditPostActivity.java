package com.suek.nyamnyam;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Notification;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

//Post 글 작성하기 Activity
public class EditPostActivity extends AppCompatActivity {
    // 로그인 정보
    CircleImageView civPofile;
    TextView tvNickName;

    EditText etTitle;
    EditText etMsg;
    ImageView iv;
    String imgPath;

    // Expandable FAB 불린 참조변수
    Boolean isOpen= false;
    FloatingActionButton fab, fab1_my_blog, fab2_board, fab3_post;
    TextView tv_my_blog, tv_board, tv_post;
    Animation fab_open, fab_close, fab_clock, fab_anticlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);

        // 로그인 정보 불러들이기
        civPofile= findViewById(R.id.civ_profile);
        tvNickName= findViewById(R.id.tv_nickName);
        SharedPreferences pref= getSharedPreferences("Data", MODE_PRIVATE);
        String profileUrl= pref.getString("profileUrl", "");
        String nickName= pref.getString("nickName", "");
        Glide.with(this).load(profileUrl).into(civPofile);
        tvNickName.setText(nickName);

        //글작성
        etTitle= findViewById(R.id.et_title);
        etMsg= findViewById(R.id.et_msg);
        iv= findViewById(R.id.iv);

        String[] permissions= new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(checkSelfPermission(permissions[0]) == PackageManager.PERMISSION_DENIED){
                requestPermissions(permissions, 100);
            }
        }



        // Expandable FAB
        fab= findViewById(R.id.fab);
        fab1_my_blog= findViewById(R.id.fab1_my_blog);
        fab2_board= findViewById(R.id.fab2_board);
        fab_open= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fab_clock= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_clock);
        fab_anticlock= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_anticlock);

        tv_my_blog= findViewById(R.id.tv_my_blog);
        tv_board= findViewById(R.id.tv_board);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isOpen){                                        //isOpen 이 true? 아닐경우 else(위에서 이미 참조불린변수에 isOpen false 라고 줌)
                    tv_my_blog.setVisibility(View.VISIBLE);
                    tv_board.setVisibility(View.VISIBLE);
                    fab2_board.startAnimation(fab_open);
                    fab1_my_blog.startAnimation(fab_open);
                    fab.startAnimation(fab_anticlock);
                    isOpen= true;   //다음에 바뀔것을 생각해서
                }else {
                    tv_my_blog.setVisibility(View.INVISIBLE);
                    tv_board.setVisibility(View.INVISIBLE);
                    fab2_board.startAnimation(fab_close);
                    fab1_my_blog.startAnimation(fab_close);
                    fab.startAnimation(fab_clock);
                    isOpen= false;
                }
            }
        });


        fab2_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Wanna check what others shared?", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(EditPostActivity.this, BoardActivity.class);
                startActivity(intent);
            }
        });

        fab1_my_blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "See what you've posted!", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(EditPostActivity.this, MyPostActivity.class);
                startActivity(intent);
            }
        });

    }//onCreate






    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==100 && grantResults[0] == PackageManager.PERMISSION_DENIED){
            Toast.makeText(this, "Image load failed", Toast.LENGTH_SHORT).show();
        }
    }




    public void clickPhoto(View view){
        Intent intent= new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 10);
    }

    //카메라앱 실행시키는 함수
    public void clickCamera(View view){
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 20);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                if(resultCode==RESULT_OK){
                    Uri uri= data.getData();
                    if(uri != null){
                        Glide.with(this).load(uri).into(iv);
                        imgPath= getRealPathFromUri(uri);
                        new AlertDialog.Builder(this).setMessage(imgPath).show();
                    }
                }
                break;

            case 20:
                if(requestCode!=RESULT_CANCELED){
                    Toast.makeText(this, "take a photo", Toast.LENGTH_SHORT).show();
                    Uri uri= data.getData();
                    if(uri!=null){
                        Glide.with(this).load(uri).into(iv);
                    }else {
                        Bundle bundle= data.getExtras();
                        Bitmap bm= (Bitmap) bundle.get("data");
                        Glide.with(this).load(bm).into(iv);
                    }
                }
                break;
        }

    }





    String getRealPathFromUri(Uri uri){
        String[] proj= {MediaStore.Images.Media.DATA};
        CursorLoader loader= new CursorLoader(this, uri, proj, null, null, null);
        Cursor cursor= loader.loadInBackground();
        int column_index= cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result= cursor.getString(column_index);
        cursor.close();
        return result;
    }




    public void clickShare(View view){
        String title= etTitle.getText().toString();
        String msg= etMsg.getText().toString();
        SharedPreferences preferences= getSharedPreferences("Data", MODE_PRIVATE);
        String email= preferences.getString("email", "");


        Retrofit retrofit= RetrofitHelper.getInstance2();
        RetrofitService retrofitService= retrofit.create(RetrofitService.class);

        Map<String, String> dataPart= new HashMap<>();
        dataPart.put("title", title);
        dataPart.put("msg", msg);
        dataPart.put("email", email);

        MultipartBody.Part filePart= null;
        if(imgPath != null){
            File file= new File(imgPath);
            RequestBody requestBody= RequestBody.create(MediaType.parse("image/*"), file);
            filePart= MultipartBody.Part.createFormData("img", file.getName(), requestBody);
        }

        Call<String> call= retrofitService.postDataToBoard(dataPart, filePart);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    String s= response.body();
                    Toast.makeText(EditPostActivity.this, ""+s, Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(EditPostActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }






    public void clickBack(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}//MainActivity
