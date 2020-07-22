package com.suek.nyamnyam;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FragmentTabHowtoCook extends Fragment {

    //받아올 데이터들
    CircleImageView civFoodFile;
    TextView tvCat;
    TextView tvTitle;
    TextView tvSub;
    TextView tvIng;
    TextView tvStep;

    ImageView ivHeadset;
    TextToSpeech textToSpeech;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.tab_howtocook_fragment, container, false);


        //받아올 데이터들 아이디 찾아주기
        civFoodFile= view.findViewById(R.id.civ_food);
        tvCat= view.findViewById(R.id.tv_cat);
        tvTitle= view.findViewById(R.id.tv_title);
        tvSub= view.findViewById(R.id.tv_sub);
        tvIng= view.findViewById(R.id.tv_ing);
        tvStep= view.findViewById(R.id.tv_step);

        //vegan adapter 에서 recipe activity 로 보낸 데이터를
        //howtocook 프래그먼트랑 연결해서 데이터를 받음
        RecipeActivity recipeActivity= (RecipeActivity)getActivity();    //howToCook 프래그먼트가 RecipeActivity 의 능력을 가짐?- 연결
        Glide.with(this).load(recipeActivity.civFood).into(civFoodFile);     //civFood <-- recipe activity 에서 받아온 데이터
        tvCat.setText(recipeActivity.foodCategory);      //foodCategory <-- recipe activity 에서 받아온 데이터
        tvTitle.setText(recipeActivity.foodTitle);      //foodTitle <-- recipe activity 에서 받아온 데이터
        tvSub.setText(recipeActivity.foodSub);
        tvIng.setText(recipeActivity.foodIng);
        tvStep.setText(recipeActivity.foodStep);








        //Text to Speech
        textToSpeech= new TextToSpeech(view.getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == textToSpeech.SUCCESS){
                    textToSpeech.setLanguage(Locale.KOREAN);
                }
            }
        });

        ivHeadset= view.findViewById(R.id.iv_headset);
        ivHeadset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.setPitch(1.0f);
                textToSpeech.setSpeechRate(0.5f);
                textToSpeech.speak(tvSub.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        return view;
    }//onCreateView..



}
