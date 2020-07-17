package com.suek.nyamnyam;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class FoodCategoryPageActivity extends AppCompatActivity {

    ArrayList<CategoryPageItems> items= new ArrayList<>();
    CategoryPageAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category_page);

        //vegan Activity 에 intent 를 통해 데이터들 가져오기..
        //drawer menu 에서 Food category 를 클릭하면 Food category 목록 보여주는 페이지(Vegan page)로 이동해서 보여지는 데이터들..
        items.add(new CategoryPageItems("https://images.happycow.net/venues/1024/14/53/hcmp145394_726578.jpeg",R.drawable.bibimbap, "VEGAN", "채식", "It's not a secret that Korea is well known as meat paradise for those meat lovers. But that doesn't mean that vegetarians can't have Korean food! We'll share general dishes how to enjoy Korean food like a pure vegetarian and you will soon fall in love."));
        items.add(new CategoryPageItems("https://recipe1.ezmember.co.kr/cache/recipe/2015/04/21/84d2afaa37d7d004c66bfb32817744a11.jpg",R.drawable.bibimbap , "SOUP", "찌개", "Jjigae is basically contains more solid ingredients such as vegetables, meat or seafood. It's common practice for families to share a pot of Jjigae, whilst Guk is prepared for each person in a bowl as a side dish."));
        items.add(new CategoryPageItems("https://www.nongsaro.go.kr/ps/img/interabang/num207/headerImg.jpg",R.drawable.bibimbap,"RICE", "밥", "Rice is called as Ssal before it's cooked and Bap after it's cooked. Rice is the basics of Korean food and harmonized with various side dishes. Koreans usually cook rice itself and also enjoy having with other grains in it."));
        items.add(new CategoryPageItems("https://m.handokmall.kr/web/product/big/201901/b76a02afec251e63c5f3013f3bd461b5.jpg", R.drawable.bibimbap,"MEAT", "고기", "Gogi is what we call for meat. Somewhat Korean BBQ is well known as a staple but there are more to offer amazing meat dishes that you've ever heard. It will not only satisfy your tongue, but also your gastric from healthy and beneficial ingredients."));
        items.add(new CategoryPageItems("https://image.auction.co.kr/itemimage/11/a9/e0/11a9e0eb26.jpg", R.drawable.bibimbap,"NOODLE", "면", "Chaesik is all about vegetarian dish in Korea..."));
        items.add(new CategoryPageItems("https://i.ytimg.com/vi/ybCOfiNp01M/maxresdefault.jpg",R.drawable.bibimbap, "VEGETABLES", "야채", "Chaesik is all about vegetarian dish in Korea..."));
        items.add(new CategoryPageItems("https://travelright.com/wp-content/uploads/2019/12/Korean-Patbingsu.jpg", R.drawable.bibimbap, "DESSERT", "디저트", "Chaesik is all about vegetarian dish in Korea..."));
        items.add(new CategoryPageItems("https://files.bonif.co.kr/upload/cmdt/BF101_pic_qhO61yeq.jpg", R.drawable.bibimbap, "PORRIDGE", "죽","Chaesik is all about vegetarian dish in Korea..."));
        items.add(new CategoryPageItems("https://d3h1lg3ksw6i6b.cloudfront.net/media/image/2019/05/17/965cc82059734e0f8d3159e99b4af981_%E1%84%81%E1%85%A9%E1%86%BE%E1%84%89%E1%85%A9%E1%86%BC%E1%84%91%E1%85%A7%E1%86%AB-1030x773.jpg",R.drawable.bibimbap, "SPECIAL", "Special","Chaesik is all about vegetarian dish in Korea..."));
        items.add(new CategoryPageItems("https://imagescdn.gettyimagesbank.com/500/201708/jv10928958.jpg",R.drawable.bibimbap ,"PANCAKE", "부침개","Chaesik is all about vegetarian dish in Korea..."));
        items.add(new CategoryPageItems("https://imagescdn.gettyimagesbank.com/500/201811/a11203592.jpg" ,R.drawable.bibimbap, "STREET FOOD", "분식","Chaesik is all about vegetarian dish in Korea..."));


        recyclerView= findViewById(R.id.recycler);
        adapter= new CategoryPageAdapter(this, items);
        recyclerView.setAdapter(adapter);

        //Intent intent








    }




}
