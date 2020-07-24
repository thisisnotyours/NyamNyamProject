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
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
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
    }//onCreate


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==100 && grantResults[0] == PackageManager.PERMISSION_DENIED){
            Toast.makeText(this, "Image load failed", Toast.LENGTH_SHORT).show();
        }
    }



    public void clickSelectImage(View view){
        Intent intent= new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==10 && resultCode==RESULT_OK){
            Uri uri= data.getData();
            if(uri != null){
                Glide.with(this).load(uri).into(iv);
                imgPath= getRealPathFromUri(uri);
                new AlertDialog.Builder(this).setMessage(imgPath).show();
            }
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

        Retrofit retrofit= RetrofitHelper.getInstance2();
        RetrofitService retrofitService= retrofit.create(RetrofitService.class);

        Map<String, String> dataPart= new HashMap<>();
        dataPart.put("title", title);
        dataPart.put("msg", msg);

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
        Intent intent= new Intent(this, BoardActivity.class);
        startActivity(intent);
    }


}//MainActivity
