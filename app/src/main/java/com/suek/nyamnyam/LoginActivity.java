package com.suek.nyamnyam;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private SignInButton btn_google;   //구글 로그인버튼
    private FirebaseAuth auth;         //파이어베이스 인증 객체
    private GoogleApiClient googleApiClient;   //구글 ApiClient 객체
    private static final int REQ_SIGN_GOOGLE= 100;  //구글 로그인했을때 결과코드


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //handler.sendEmptyMessageDelayed(0, 3000);

        //로그인이 적용이 되어있다면 메인화면으로 바로 전환
        SharedPreferences pref= getSharedPreferences("Data", MODE_PRIVATE);
        String nickName= pref.getString("nickName", "");
        if(!nickName.equals("")){    //nickName 이 " "가 아니면 == nickName 이 없으면
            Intent intent= new Intent(this, MainActivity.class);
            startActivity(intent);
        }else {
            //신규 사용자 가입 로그인
            //사인버튼을 누르면 기본적으로 세팅되는 옵션들..
            GoogleSignInOptions googleSignInOptions= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.default_web_client_id))
                    .requestEmail().build();

            googleApiClient= new GoogleApiClient.Builder(this).enableAutoManage(this, this)
                    .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions).build();

            auth= FirebaseAuth.getInstance();    //파이어베이스 인증객체 초기화


            btn_google= findViewById(R.id.btn_google);
            btn_google.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("login","aaa");
                    Intent intent= Auth.GoogleSignInApi.getSignInIntent(googleApiClient);   //구글 인증 액티비티(구글이 만든 다른 화면으로)으로 이동
                    startActivityForResult(intent, REQ_SIGN_GOOGLE);
                }
            });
        }


    }//onCreate..


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQ_SIGN_GOOGLE){
            Log.i("login","bbb");
            GoogleSignInResult result= Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if(result.isSuccess()){
                Log.i("login","ccc");
                GoogleSignInAccount account= result.getSignInAccount();  //account= 구글로그인 정보를 담고있음(닉네임, 프로필사진, 이메일주소..etc)
                resultLogin(account);  //로그인 결과값 실행하는 메소드
            }
        }

    }


    //로그인 인증 결과
    private void resultLogin(GoogleSignInAccount account) {      //account= 구글로그인 정보를 담고있음(닉네임, 프로필사진, 이메일주소..etc)
        AuthCredential credential= GoogleAuthProvider.getCredential(account.getIdToken(), null);
        auth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {     //로그인 인증결과
                if(task.isSuccessful()){
                    Log.i("login","ddd");
                    Toast.makeText(LoginActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(getApplicationContext(), AccessActivity.class);
                    intent.putExtra("email", account.getEmail());
                    intent.putExtra("nickName", account.getDisplayName());                  //구글에서 지정한 닉네임을 가져올수있음
                    intent.putExtra("profileUrl", String.valueOf( account.getPhotoUrl()));  //구글에서 지정한 프로필 사진을 가져올수있음- 특정자료형을 String 형태로 변환시키는 형태
                    //G.profileUrl= account.getPhotoUrl().toString();  //로그인하고 G에 저장
                    startActivity(intent);
                    finish();

                    //Log.i("photoUrl", account.getPhotoUrl().toString());


                }else {
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }





    //비회원 메인화면으로 바로가기 버튼
    public void clickNonMember(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}//Login Activity..
