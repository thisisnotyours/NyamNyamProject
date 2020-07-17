package com.suek.nyamnyam;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentTabHowtoCook extends Fragment {

    //받아올 데이터들
    CircleImageView civFood;
    TextView tvCategory;
    TextView tvTitile;
    TextView tvSub;

    ImageView ivHeadset;
    TextToSpeech textToSpeech;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.tab_howtocook_fragment, container, false);


        //받아올 데이터들 아이디 찾아주기
        civFood= view.findViewById(R.id.civ_food);
        tvCategory= view.findViewById(R.id.tv_food_category);
        tvTitile= view.findViewById(R.id.tv_food_title);
        tvSub= view.findViewById(R.id.tv_food_title_sub);

        //액티비티에서 프레그먼트를 연결해주기 위해 RecipeActivity 를 get 해온다.
        RecipeActivity recipeActivity= (RecipeActivity)getActivity();
        Glide.with(this).load(recipeActivity.civFood).into(civFood);
        tvCategory.setText(recipeActivity.foodCategory);
        tvTitile.setText(recipeActivity.foodTitle);
        tvSub.setText(recipeActivity.foodSub);




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
    }


}
